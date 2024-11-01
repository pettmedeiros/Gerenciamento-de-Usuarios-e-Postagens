package com.peterson.wrokshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterson.wrokshopmongo.domain.User;
import com.peterson.wrokshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // mecanismo de injeção de dependencia automática do spring
	private UserRepository repo; 
	
	public List<User> findAll(){ // método responsavel por retornar todos os usuários
		return repo.findAll();
		
		 
	}

}
