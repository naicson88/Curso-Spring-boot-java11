package com.example.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import com.example.curso.repositories.OrderRepository;
import com.example.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderReposity;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Calor", "Carlos@hotmail.com", "55599959", "91628319");
		User u2 = new User(null, "Mariana", "Marihotmail.com", "88899959", "805847159");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderReposity.saveAll(Arrays.asList(o1,o2,o3));
	}
}
