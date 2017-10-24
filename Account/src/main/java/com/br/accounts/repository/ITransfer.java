package com.br.accounts.repository;

import java.util.List;

import com.br.accounts.entity.Transacoes;

public interface ITransfer {

	void transferi(Transacoes transacoes);
	List<Transacoes> getlist();
	Transacoes getById(int TransfernciaId);

}
