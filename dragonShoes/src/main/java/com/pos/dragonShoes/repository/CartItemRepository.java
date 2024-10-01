package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{

	public List<CartItem> findAll();
}
