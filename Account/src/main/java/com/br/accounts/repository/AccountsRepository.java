package com.br.accounts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.accounts.entity.Accounts;



@Transactional
@Repository
public class AccountsRepository {
	
	@Autowired
	private RepositoryRafa repositoryRafa;
	
	@SuppressWarnings("unchecked")
	
	public List<Accounts> getAllConsulta() {
		
		List<Accounts> list = (List) repositoryRafa.findAll().stream().collect(Collectors.toList());
		return list;
	}
	
	
	public Accounts getById(int consultaId) {
		return repositoryRafa.getById(consultaId);
	}

	
	public void add(Accounts consulta) {
		repositoryRafa.save(consulta);	
	}

	
	public void update(Accounts consulta) {
		Accounts cons = getById(consulta.getId());	
		cons.setId(consulta.getId());
		cons.setNome(consulta.getNome());
		repositoryRafa.save(cons);
	}
	
	
	
	public void delete(int consultaId) {
		repositoryRafa.delete(getById(consultaId));
	}

	
	
}
