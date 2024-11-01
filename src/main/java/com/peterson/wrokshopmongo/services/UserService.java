package com.peterson.wrokshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterson.wrokshopmongo.domain.User;
import com.peterson.wrokshopmongo.repository.UserRepository;
import com.peterson.wrokshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired // mecanismo de injeção de dependencia automática do spring
	private UserRepository repo; 
	
	public List<User> findAll(){ // método responsavel por retornar todos os usuários
		return repo.findAll();		 
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
