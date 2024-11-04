package com.peterson.wrokshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peterson.wrokshopmongo.domain.Post;
import com.peterson.wrokshopmongo.resources.util.URL;
import com.peterson.wrokshopmongo.services.PostService;

@RestController // essa anotação retorna a classe com dados diretamente no formato JSON
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){

		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decoParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
		//Esse método permite que um cliente faça uma requisição GET para buscar postagens com base em um título fornecido na query string. 
		//O método processa o texto, faz uma chamada a um serviço que recupera as postagens correspondentes e retorna a lista dentro de uma resposta HTTP adequada.
	}
}
