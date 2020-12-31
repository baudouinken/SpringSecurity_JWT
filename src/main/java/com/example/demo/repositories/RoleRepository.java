package com.example.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{
	
	Optional<Role> findByName(ERole name);

}
