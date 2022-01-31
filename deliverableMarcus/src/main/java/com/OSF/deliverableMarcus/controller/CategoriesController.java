package com.OSF.deliverableMarcus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSF.deliverableMarcus.entity.Categories;
import com.OSF.deliverableMarcus.service.CategoriesService;

@RestController
@RequestMapping("/api/osf.categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping(value = { "", "/" })
    public List<Categories> getCategory() {
        return this.categoriesService.getAllCategories();
    }
	
	@GetMapping(value = {"/{id}"})
    public Categories getCategoryById(@PathVariable (value = "id") long categoryId) {
        return this.categoriesService.getCategory(categoryId);
    }
	
	@PostMapping
	public void registerNewCategory(@RequestBody Categories category) {
		categoriesService.addNewCategory(category);
	}
	
	@DeleteMapping(path= "{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		categoriesService.deleteCategory(categoryId);
	}
	
	@PutMapping(path= "{categoryId}")
	public void updateCategory(@RequestBody Categories category, @PathVariable("categoryId") Long categoryId) {
		categoriesService.updateCategory(category, categoryId);
	}
	
}