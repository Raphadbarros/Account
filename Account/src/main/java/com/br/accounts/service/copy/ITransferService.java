package com.br.accounts.service.copy;

import java.util.List;

import com.br.accounts.entity.Transacoes;

public interface  ITransferService {

	void Trasacoes(Transacoes transacoes);
	Transacoes getbyId(int id);
	List<Transacoes> getAll();
		
}

	