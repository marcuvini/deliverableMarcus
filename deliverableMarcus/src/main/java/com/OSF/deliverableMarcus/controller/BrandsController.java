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

import com.OSF.deliverableMarcus.entity.Brands;
import com.OSF.deliverableMarcus.service.BrandsService;

@RestController
@RequestMapping("/api/osf.brands")
public class BrandsController {
	
	@Autowired
	private BrandsService brandsService;
	
	@GetMapping(value = { "", "/" })
    public List<Brands> getBrand() {
        return this.brandsService.getAllBrands();
    }
	
	@GetMapping(value = {"/{id}"})
    public Brands getBrandById(@PathVariable (value = "id") long brandId) {
        return this.brandsService.getBrand(brandId);
    }
	
	@PostMapping
	public void registerNewBrand(@RequestBody Brands brand) {
		brandsService.addNewBrand(brand);
	}
	
	@DeleteMapping(path= "{brandId}")
	public void deleteBrand(@PathVariable("brandId") Long brandId) {
		brandsService.deleteBrand(brandId);
	}
	
	@PutMapping(path= "{brandId}")
	public void updateBrand(@RequestBody Brands brand, @PathVariable("brandId") Long brandId) {
		brandsService.updateBrand(brand, brandId);
	}
	
}