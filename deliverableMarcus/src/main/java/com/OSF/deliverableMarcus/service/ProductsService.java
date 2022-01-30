package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.OSF.deliverableMarcus.entity.Products;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.ProductsRepository;


@Service
public class ProductsService {

	private ResourceExceptionHandler resExHand;
		
	private ProductsRepository productsRepository;
	
	@Autowired
	public ProductsService(ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	// GET ALL PRODUCTS
	
	public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

	// GET PRODUCT BY ID
	
    public Products getProduct(long id) {
        return productsRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Product not found"));
    }
 	
    // CREATE NEW PRODUCT
    
 		public void addNewProduct(Products product) {
		this.productsRepository.save(product);
	}
 		
 	// DELETE PRODUCT
 		
 		public void deleteProduct(long productId) {
 			productsRepository.findById(productId);
 			boolean exists = productsRepository.existsById(productId);
 			if (!exists) {
 				throw new IllegalStateException("Product with id" + productId + "does not exists.");
 				
 			}
 			 	productsRepository.deleteById(productId);			
 		}

 	// UPDATE PRODUCT
 		
 		@Transactional
		public void updateProduct(Products product, long productId) {
 			// productsRepository.findById(productId);
			Products existingProduct = this.productsRepository.findById(productId)
					.orElseThrow(() -> new IllegalStateException("product with id" + productId + "does not exists."));
 			 
			if (product.getProductName() != null &&
				product.getProductName().length() > 0 &&
				!Objects.equals(product.getProductName(), existingProduct.getProductName())) {
				existingProduct.setProductName(product.getProductName());				
			}
			
			if (product.getBrandId() > 0 &&
				!Objects.equals(product.getBrandId(), existingProduct.getBrandId())) {
					existingProduct.setBrandId(product.getBrandId());				
			}
			
			if (product.getCategoryId() > 0 &&
				!Objects.equals(product.getCategoryId(), existingProduct.getCategoryId())) {
						existingProduct.setCategoryId(product.getCategoryId());				
			}
			
			if (product.getModelYear() > 0 &&
				!Objects.equals(product.getModelYear(), existingProduct.getModelYear())) {
						existingProduct.setModelYear(product.getModelYear());				
			}
			
			if (product.getListPrice() >= 0 &&
				!Objects.equals(product.getListPrice(), existingProduct.getListPrice())) {
						existingProduct.setListPrice(product.getListPrice());				
			}
		}

 		
}
 		
 		
	
//    // save product
//	@PostMapping
//	public Products createProduct(@RequestBody Products product) {
//        return this.productsRepository.save(product);
//    }
    
    // update product
//	@PutMapping("/{id}")
// 	public Products updateProduct(@RequestBody Products product, @PathVariable ("id") long productId) {
// 		Products existingProduct = this.productsRepository.findById(productId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + productId));
// 		existingProduct.setProductName(product.getProductName());
// 		existingProduct.setBrandId(product.getBrandId());
// 		existingProduct.setCategoryId(product.getCategoryId());
// 		existingProduct.setModelYear(product.getModelYear());
// 		existingProduct.setListPrice(product.getListPrice());
// 			return this.productsRepository.save(existingProduct);
//    
//} 
 
 	// delete product by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Products> deleteProduct(@PathVariable ("id") long productId) {
// 		Products existingProduct = this.productsRepository.findById(productId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + productId));
// 		this.productsRepository.delete(existingProduct);
// 		return ResponseEntity.ok().build();
 //	}

