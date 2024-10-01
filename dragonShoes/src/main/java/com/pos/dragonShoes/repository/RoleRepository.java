package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.Role;


public interface RoleRepository extends CrudRepository<Role,Long>{
	
	public List<Role> findAll();
}
