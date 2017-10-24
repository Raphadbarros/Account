package com.br.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.accounts.entity.Transacoes;
import com.br.accounts.service.copy.ITransferService;


@Controller
@RequestMapping(name = "Transacoes")
public class TransferController {

	@Autowired
	public ITransferService transferservice; 
	
	@PostMapping("transacoes")
	public ResponseEntity<Void> transferi (@RequestBody Transacoes transacoesjson, UriComponentsBuilder builder){
		
		if(transacoesjson == null){
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}else {
		
		 transferservice.Trasacoes(transacoesjson);
		 HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(builder.path("/accounts/{id}").buildAndExpand(transacoesjson.getTransfernciaId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	
		
	}
	
	@GetMapping("transacoes")
	public ResponseEntity<List<Transacoes>> getAll() {
		List<Transacoes> list = transferservice.getAll();
		return new ResponseEntity<List<Transacoes>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("transacoes/{id}") 
	public ResponseEntity <Transacoes> getbyId(@PathVariable ("id")Integer id){
		Transacoes transf = transferservice.getbyId(id);
		return new ResponseEntity<Transacoes>(transf,HttpStatus.OK);
	}
	
	
		
}
