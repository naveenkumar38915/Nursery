package com.nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.models.Category;
import com.nursery.repos.CategoryRepository;

@Service
public class CategoryService {

	@Autowired private CategoryRepository repo;
	
	public void save(Category cat) {
		repo.save(cat);
	}
	
	public List<Category> listAll(){
		return repo.allActiveCategory();
	}
	
	public Category findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteCategory(int id) {
		Category cat=findById(id);
		cat.setIsactive(false);
		repo.save(cat);
	}

	public void updateStatus(int id, boolean status) {
		Category cat=findById(id);
		cat.setIsactive(status);
		repo.save(cat);		
	}
}
