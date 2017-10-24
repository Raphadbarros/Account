package com.br.accounts.service.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.accounts.entity.Accounts;
import com.br.accounts.entity.Transacoes;
import com.br.accounts.repository.AccountsRepository;
import com.br.accounts.repository.TransfRepository;

@Service
public class TransfServico implements ITransferService{

	@Autowired
	public TransfRepository transrepository;
	
	@Autowired
	public AccountsRepository accontsrepository;
	
	public void Trasacoes(Transacoes transacoes){
		
		Accounts accountOrigem = accontsrepository.getById(transacoes.getContaOrigen());
		Accounts accountDestino = accontsrepository.getById(transacoes.getContaDestino());
	    String _tipo = transacoes.getTipo();
		
		Validations(accountOrigem);
		Validations(accountDestino);
		
		if( _tipo.equalsIgnoreCase("ESTORNO") && accountDestino.getParentID()>0){
			
			ValidaSaldo(transacoes.getValor(), accountOrigem);
			SensibilizaSaldo(accountOrigem,accountDestino,transacoes.getValor(), transacoes.getTipo(),transacoes.getTransfernciaId());
			transacoes.setMovimentacao('D');
			transrepository.transferi(transacoes);
			
		}
		if(_tipo.equalsIgnoreCase("DOC")  && accountDestino.getParentID()>=0){
			
		 ValidaSaldo(transacoes.getValor(), accountOrigem);
		 PertenceMesma(accountOrigem,accountDestino);
		 SensibilizaSaldo(accountOrigem,accountDestino,transacoes.getValor(),transacoes.getTipo(),transacoes.getTransfernciaId());
		 transacoes.setMovimentacao('C');
		 transrepository.transferi(transacoes);
		 		 
		}
		if(transacoes.getTipo() == "APORTE" && accountDestino.getParentID() >=0){		 
			
			 SensibilizaSaldo(accountOrigem,accountDestino,transacoes.getValor(),transacoes.getTipo(),transacoes.getTransfernciaId());
			 transacoes.setMovimentacao('C');
			 transrepository.transferi(transacoes);	
		
		}
		
	}
	
	public void Validations(Accounts account) {
		
		if (account.IsActive()) {
			
		}else{
			throw new RuntimeException("ACCOUNT IS NOT ACTIVE!");
		}
		
	}
	
	public boolean ValidaSaldo(double valor, Accounts acc){
		
	 try {  
		 if(acc.getSaldo() >= valor)   
			  return true;  
	     } catch (NumberFormatException ex) {
		             
	       }  
	 		  return false;
		 }
	
	public boolean PertenceMesma(Accounts accountOri,Accounts accountDes)
	{
		if(accountDes.getParentID() > 0 && accountDes.getParentID() == accountOri.getId())
		return true;
		
		return false;
	}
	

	public boolean SensibilizaSaldo (Accounts accountOri, Accounts accountDes,double valor,String tipo, int transId){
		
		if(tipo.equalsIgnoreCase("DOC")){
			double saldorigen = accountOri.getSaldo();
			double saldoDestino = accountDes.getSaldo();
			accountOri.setSaldo(saldorigen - valor);
			accountDes.setSaldo(saldoDestino + valor);
			return true;
		}
		
		if(tipo.equalsIgnoreCase("APORTE")){
			double saldoDestino = accountDes.getSaldo();
			accountDes.setSaldo(saldoDestino + valor);
			return true;
		}
		
		if(tipo.equalsIgnoreCase("ESTORNO")){
			double saldorigen = accountOri.getSaldo();
			double saldoDestino = accountDes.getSaldo();
			accountOri.setSaldo(saldorigen + valor);
			accountDes.setSaldo(saldoDestino - valor);
			
			return true;
		}
		
		return false;
	}

	public Transacoes getbyId(int id) {
		return transrepository.getById(id);
	}

	public List<Transacoes> getAll() {		
		return transrepository.getlist();
	}
		
}
