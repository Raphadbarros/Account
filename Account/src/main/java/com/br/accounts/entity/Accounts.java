package com.br.accounts.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Accounts_Id")
	private int id;
	
	@Column(name="Nome")
	private String  Nome;
	
	@Column(name="Data_Creat")
	private Date DataCreat;
	
	@Column(name="Parent_Id")
	private int parentID;
	
	@Column(name ="Situacao")
	private int Situacao;
	
	@Column(name="Tipo") 
	private String Tipo;
	
	@Column(name="Saldo")
	private double Saldo;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getDataCreat() {
		return DataCreat;
	}
	public void setDataCreat(Date dataCreat) {
		DataCreat = dataCreat;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public int getSituacao() {
		return Situacao;
	}
	public void setSituacao(int situacao) {
		Situacao = situacao;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public double getSaldo() {
		return Saldo;
	}
	public void setSaldo(double saldo) {
		Saldo = saldo;
	}
	public boolean MainAccount()
	{
		if (this.parentID > 0){
			return true;
		}
		
		return false;
	}

	public boolean IsActive(){
		  if(this.getSituacao() == 1)
			  return true;
		  
		return false;
	}
		
}
