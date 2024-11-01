package com.peterson.wrokshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peterson.wrokshopmongo.domain.User;
import com.peterson.wrokshopmongo.services.UserService;

@RestController // essa anotação retorna a classe com dados diretamente no formato JSON
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){

		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	

}
