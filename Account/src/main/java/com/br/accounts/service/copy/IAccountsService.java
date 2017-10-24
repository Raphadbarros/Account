package com.br.accounts.service.copy;

import java.util.List;

import com.br.accounts.entity.Accounts;

public interface IAccountsService {

	Accounts getbyId(int id);
	List<Accounts> getAll();
	void add(Accounts consulta, int id);
	void update(Accounts consulta);
	void delete(int id);
	
}
