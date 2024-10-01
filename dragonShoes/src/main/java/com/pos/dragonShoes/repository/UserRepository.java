package com.pos.dragonShoes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.dragonShoes.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email,String pass);
	Optional<User> findByEmail(String email);
	
	@Query("SELECT p from User p where p.role.id = 2")
	public List<User> findAllUsers();
}
