package com.peterson.wrokshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.peterson.wrokshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title': {$regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); //método de busca, isso faz com que o spring data monte a consulta query
}
