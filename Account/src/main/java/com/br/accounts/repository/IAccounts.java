package com.br.accounts.repository;

import java.util.List;

import com.br.accounts.entity.Accounts;

public interface IAccounts {

	List<Accounts> getAllConsulta();
	Accounts getById(int consultaId);
	void add(Accounts consulta);
	void update(Accounts consultaId);
	void delete (int consultaId);
	//boolean ConsultaExistente(String title,String Category);
}
