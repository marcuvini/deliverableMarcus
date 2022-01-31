package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Categories;
import com.OSF.deliverableMarcus.repository.CategoriesRepository;


@Service
public class CategoriesService {

		
	private CategoriesRepository categoriesRepository;
	
	@Autowired
	public CategoriesService(CategoriesRepository categoriesRepository) {
		super();
		this.categoriesRepository = categoriesRepository;
	}

	// GET ALL CUSTOMERS
	
	public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

	// GET CUSTOMER BY ID
	
    public Categories getCategory(long id) {
        return categoriesRepository
          .findById(id)
          .orElseThrow(() -> new IllegalStateException("Category not found"));
    }
 	
    // CREATE NEW CUSTOMER
    
 		public void addNewCategory(Categories category) {
		this.categoriesRepository.save(category);
	}
 		
 	// DELETE CUSTOMER
 		
 		public void deleteCategory(long categoryId) {
 			categoriesRepository.findById(categoryId);
 			boolean exists = categoriesRepository.existsById(categoryId);
 			if (!exists) {
 				throw new IllegalStateException("Category with id" + categoryId + "does not exists.");
 				
 			}
 			 	categoriesRepository.deleteById(categoryId);			
 		}

 	// UPDATE CUSTOMER
 		
 		@Transactional
		public void updateCategory(Categories category, long categoryId) {
 			// categoriesRepository.findById(categoryId);
			Categories existingCategory = this.categoriesRepository.findById(categoryId)
					.orElseThrow(() -> new IllegalStateException("Category with id" + categoryId + "does not exists."));
 			 
			if (category.getCategoryName() != null &&
				category.getCategoryName().length() > 0 &&
				!Objects.equals(category.getCategoryName(), existingCategory.getCategoryName())) {
				existingCategory.setCategoryName(category.getCategoryName());				
			}
			
		}

 		
}
 		
 		
	
//    // save category
//	@PostMapping
//	public Categories createCategory(@RequestBody Categories category) {
//        return this.categoriesRepository.save(category);
//    }
    
    // update category
//	@PutMapping("/{id}")
// 	public Categories updateCategory(@RequestBody Categories category, @PathVariable ("id") long categoryId) {
// 		Categories existingCategory = this.categoriesRepository.findById(categoryId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + categoryId));
// 		existingCategory.setFirstName(category.getFirstName());
// 		existingCategory.setCategoryId(category.getCategoryId());
// 		existingCategory.setCategoryId(category.getCategoryId());
// 		existingCategory.setModelYear(category.getModelYear());
// 		existingCategory.setListPrice(category.getListPrice());
// 			return this.categoriesRepository.save(existingCategory);
//    
//} 
 
 	// delete category by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Categories> deleteCategory(@PathVariable ("id") long categoryId) {
// 		Categories existingCategory = this.categoriesRepository.findById(categoryId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + categoryId));
// 		this.categoriesRepository.delete(existingCategory);
// 		return ResponseEntity.ok().build();
 //	}

