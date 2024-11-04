package com.peterson.wrokshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peterson.wrokshopmongo.domain.Post;
import com.peterson.wrokshopmongo.repository.PostRepository;
import com.peterson.wrokshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired // mecanismo de injeção de dependencia automática do spring
	private PostRepository repo; 

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
