package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

	public List<Cart> findAll();
}
