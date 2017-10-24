package com.br.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.accounts.entity.Accounts;

@Repository
public interface RepositoryRafa extends JpaRepository<Accounts, Integer> {
	
	public Accounts getById(int id);
		
}
