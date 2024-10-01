package com.pos.dragonShoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.FootwearDetail;
import com.pos.dragonShoes.repository.FootwearDRepository;
@Service
public class FootwearDService {

	@Autowired
	private FootwearDRepository footwearDRep;
	
	public List<FootwearDetail> findAll(){
		return footwearDRep.findAll();
	}

	public Optional<FootwearDetail> findById(long id) {
		return footwearDRep.findById(id);
	}
	
	public void saveFootwearD(FootwearDetail footwear) {
		footwearDRep.save(footwear);
	}
	
	public void deleteFootwearD(FootwearDetail footwear) {
		try {
			footwearDRep.deleteById(footwear.getId());
		} catch (Exception e) {
			
		}
	}
	
	public void updateFootwearD(long id, FootwearDetail footwear) {
		footwear.setId(null);
		footwearDRep.save(footwear);
	}
	
//	public List<Footwear> findByFootwearNameSize(String name){
//		return footwearRep.findGroupedBySize(name);
//	}
}
