package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pos.dragonShoes.entity.FootwearDetail;

public interface FootwearDRepository extends CrudRepository<FootwearDetail, Long> {

	public List<FootwearDetail> findAll();
	/*
	 * @Query("SELECT f.name, f.color, f.size FROM Footwear f WHERE f.name = :name GROUP BY f.name, f.color, f.size"
	 * ) List<Footwear> findGroupedBySize(@Param("name") String name);
	 */

}
