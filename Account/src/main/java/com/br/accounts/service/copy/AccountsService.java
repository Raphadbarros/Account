package com.br.accounts.service.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.accounts.entity.Accounts;
import com.br.accounts.repository.AccountsRepository;

@Service
public class AccountsService {
	
	@Autowired
	public AccountsRepository consultareposi;
	
	
	public Accounts getbyId(int id) {
		return consultareposi.getById(id);
		
	}

	
	public List<Accounts> getAll() {
		return consultareposi.getAllConsulta();
	}


	public void update(Accounts consulta) {
		consultareposi.update(consulta);
	}

	
	public void delete(int id) {
		consultareposi.delete(id);		
	}

	
	public void add(Accounts consulta) {
		consultareposi.add(consulta);
	}

}
