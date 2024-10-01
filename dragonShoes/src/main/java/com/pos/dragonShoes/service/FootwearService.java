package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.Footwear;
import com.pos.dragonShoes.repository.FootwearRepository;
@Service
public class FootwearService {

	@Autowired
	private FootwearRepository footwearRep;
	
	public List<Footwear> findAll(){
		return footwearRep.findAll();
	}

	public Optional<Footwear> findById(long id) {
		return footwearRep.findById(id);
	}
	
	public void saveFootwear(Footwear footwear) {
		footwearRep.save(footwear);
	}
	
	public void deleteFootwear(Footwear footwear) {
		try {
			footwearRep.deleteById(footwear.getId());
		} catch (Exception e) {
			
		}
	}
	
	public void updateCategory(long id, Footwear footwear) {
		footwear.setId(null);
		footwearRep.save(footwear);
	}
	
//	public List<Footwear> findByFootwearNameSize(String name){
//		return footwearRep.findGroupedBySize(name);
//	}
}
