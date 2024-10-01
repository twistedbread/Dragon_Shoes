package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.Role;
import com.pos.dragonShoes.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRep;
	
	public List<Role> findAll(){
		return roleRep.findAll();
	}

	public Optional<Role> findById(long id) {
		return roleRep.findById(id);
	}
}
