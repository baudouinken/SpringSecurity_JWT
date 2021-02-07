package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;

@SpringBootApplication
public class SpringSecReactApplication implements CommandLineRunner{
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecReactApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role();
		role1.setId(UUID.randomUUID());
		role1.setName(ERole.ROLE_ADMIN);
		roleRepository.save(role1);

		Role role2 = new Role();
		role2.setId(UUID.randomUUID());
		role2.setName(ERole.ROLE_MODERATOR);
		roleRepository.save(role2);

		Role role3 = new Role();
		role3.setId(UUID.randomUUID());
		role3.setName(ERole.ROLE_USER);
		roleRepository.save(role3);

	}

}
