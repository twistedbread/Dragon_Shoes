package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.Cart;
import com.pos.dragonShoes.repository.CartRepository;
@Service
public class CartService {

	@Autowired
	private CartRepository cartRep;

	public List<Cart> findAll(){
		return cartRep.findAll();
	}
	
	public Optional<Cart> findById(Long id){
		return cartRep.findById(id);
	}
	
	public void saveCart(Cart cart) {
		cartRep.save(cart);
	}
	
	public void deleteCart(Cart cart) {
		try {
			cartRep.deleteById(cart.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateCart(long id, Cart cart) {
		cart.setId(id);
		cartRep.save(cart);
	}
}
