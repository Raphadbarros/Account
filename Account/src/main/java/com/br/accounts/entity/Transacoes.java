package com.br.accounts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transacoes")
public class Transacoes {

	public Transacoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TransfernciaId;
	@Column
	private String Tipo;
	@Column
	private int ContaOrigen;
	@Column
	private int ContaDestino;
	@Column
	private double valor;
	@Column
	private char movimentacao;
		
	
	/*public Transacoes(int accountOrigem, int acconuntDestino, Double valor, String tipo,char movimentacao) {
		this.Tipo = tipo;
		this.ContaDestino = acconuntDestino;
		this.ContaDestino = acconuntDestino;
		this.valor = valor;	
		this.movimentacao  = movimentacao;
	}*/
	
	public char getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(char movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	public int getContaOrigen() {
		return ContaOrigen;
	}
	public void setContaOrigen(int contaOrigen) {
		ContaOrigen = contaOrigen;
	}
	public int getContaDestino() {
		return ContaDestino;
	}
	public void setContaDestino(int contaDestino) {
		ContaDestino = contaDestino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getTransfernciaId() {
		return TransfernciaId;
	}
	public void setTransfernciaId(int transfernciaId) {
		this.TransfernciaId = transfernciaId;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	
}
