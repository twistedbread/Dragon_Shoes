package com.pos.dragonShoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.Category;
import com.pos.dragonShoes.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository catRep;
	
	public List<Category> findAll(){
		return catRep.findAll();
	}

	public Optional<Category> findById(long id) {
		return catRep.findById(id);
	}
	
	 public void saveCategory(Category category) {			
			catRep.save(category);
		}
	 public void deleteCategory(Category category) {
		 try {
			 catRep.deleteById(category.getId());
		} catch (Exception e) {
			// TODO: handle exception
	}
			
		}
	 public void updateCategory(long id, Category cat) {
			cat.setId(id);
			catRep.save(cat);
	}
	 public List<Category> searchData(String data){
		 List<Category> listCategory = new ArrayList<Category>();
		 for(Category category : catRep.findAll()) {
			 if(category.getId().toString().equalsIgnoreCase(data) || 
					 category.getDescription().equalsIgnoreCase(data) )
				 listCategory.add(category);
		 }
		 return listCategory;
	 }
}
