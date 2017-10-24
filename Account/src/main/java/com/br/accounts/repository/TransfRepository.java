package com.br.accounts.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.accounts.entity.Transacoes;

@Transactional
@Repository
public class TransfRepository implements ITransfer{
	
	@Autowired
	public EntityManager entitymanager;

	public ITransfer transf; 

	
	public List<Transacoes> getlist() {
		String hql = "from Transacoes ";
		return (List<Transacoes>)entitymanager.createQuery(hql).getResultList();
		
	}

	
	public Transacoes getById(int TransfernciaId) {
		return entitymanager.find(Transacoes.class, TransfernciaId);		
	}

	@Transactional(readOnly = false)
	public void transferi(Transacoes transacoes) {
		entitymanager.persist(transacoes);
	}
	
		
}
