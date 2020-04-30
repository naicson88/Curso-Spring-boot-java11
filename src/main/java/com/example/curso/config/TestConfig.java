package com.example.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.User;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Calor", "Carlos@hotmail.com", "55599959", "91628319");
		User u2 = new User(null, "Mariana", "Marihotmail.com", "88899959", "805847159");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
