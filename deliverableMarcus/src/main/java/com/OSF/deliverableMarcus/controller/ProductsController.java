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

import com.OSF.deliverableMarcus.entity.Products;
import com.OSF.deliverableMarcus.service.ProductsService;

@RestController
@RequestMapping("/api/osf.products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping(value = { "", "/" })
    public List<Products> getProduct() {
        return this.productsService.getAllProducts();
    }
	
	@PostMapping
	public void registerNewProduct(@RequestBody Products product) {
		productsService.addNewProduct(product);
	}
	
	@DeleteMapping(path= "{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId) {
		productsService.deleteProduct(productId);
	}
	
	@PutMapping(path= "{productId}")
	public void updateProduct(@RequestBody Products product, @PathVariable("productId") Long productId) {
		productsService.updateProduct(product, productId);
	}
	
	
//	
//	@PostMapping
//	public Products createProduct(@RequestBody Products product) {
//        return this.productsService.createProduct(product);
//    }
}
