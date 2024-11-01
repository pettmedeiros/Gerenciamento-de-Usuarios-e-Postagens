package com.peterson.wrokshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterson.wrokshopmongo.domain.User;
import com.peterson.wrokshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj); // responsavel por copiar os dados do obj para o newObj
		return repo.save(newObj);
		
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
