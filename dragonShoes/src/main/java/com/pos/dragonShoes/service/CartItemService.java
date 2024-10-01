package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.CartItem;
import com.pos.dragonShoes.repository.CartItemRepository;
@Service
public class CartItemService {

	@Autowired
	private CartItemRepository cartItemRep;

	public List<CartItem> findAll(){
		return cartItemRep.findAll();
	}
	
	public Optional<CartItem> findById(Long id){
		return cartItemRep.findById(id);
	}
	
	public void saveCartItem(CartItem cartItem) {
		cartItemRep.save(cartItem);
	}
	
	public void deleteCartItem(CartItem cartItem) {
		try {
			cartItemRep.deleteById(cartItem.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
