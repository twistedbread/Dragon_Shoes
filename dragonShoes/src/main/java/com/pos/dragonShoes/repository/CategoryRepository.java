package com.pos.dragonShoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pos.dragonShoes.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	public List<Category> findAll();
}
