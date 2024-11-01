package com.peterson.wrokshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.peterson.wrokshopmongo.domain.User;
import com.peterson.wrokshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepositor;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepositor.deleteAll(); // vai deletar tudo no mongo
		
		//instaciar novos dados
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepositor.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
