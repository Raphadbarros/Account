package com.br.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.accounts.entity.Accounts;
import com.br.accounts.service.copy.AccountsService;

@Controller
@RequestMapping(name="accounts")

public class AccountsController {
	@Autowired
	private AccountsService accountService;
	
	
	@GetMapping("accounts/{id}")
	public ResponseEntity<Accounts> getById(@PathVariable("id")Integer id){
		accountService.getbyId(id);
		return new ResponseEntity<Accounts>(accountService.getbyId(id), HttpStatus.OK);	
	}
	
	@GetMapping("accounts")
	public ResponseEntity<List<Accounts>> getAll(){
		List<Accounts> list = accountService.getAll(); 
		return new ResponseEntity<List<Accounts>>(list, HttpStatus.OK);
		
	}
	
	@PostMapping("accounts")
	public ResponseEntity<Void> add(@RequestBody Accounts account, UriComponentsBuilder builder){
		
		if (account == null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			
		}else{	 
		
			 accountService.add(account);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(builder.path("/accounts/{id}").buildAndExpand(account.getId()).toUri());
		     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	
	
	
	@PutMapping ("accounts")
		public ResponseEntity<Accounts> update(@RequestBody Accounts account){
		accountService.update(account);
		return new ResponseEntity<Accounts> (HttpStatus.OK);
	}
	
	@DeleteMapping("accounts/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
		accountService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	
}
