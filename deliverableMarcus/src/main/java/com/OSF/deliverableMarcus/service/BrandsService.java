package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Brands;
import com.OSF.deliverableMarcus.repository.BrandsRepository;


@Service
public class BrandsService {

		
	private BrandsRepository brandsRepository;
	
	@Autowired
	public BrandsService(BrandsRepository brandsRepository) {
		super();
		this.brandsRepository = brandsRepository;
	}

	// GET ALL CUSTOMERS
	
	public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

	// GET CUSTOMER BY ID
	
    public Brands getBrand(long id) {
        return brandsRepository
          .findById(id)
          .orElseThrow(() -> new IllegalStateException("Brand not found"));
    }
 	
    // CREATE NEW CUSTOMER
    
 		public void addNewBrand(Brands brand) {
		this.brandsRepository.save(brand);
	}
 		
 	// DELETE CUSTOMER
 		
 		public void deleteBrand(long brandId) {
 			brandsRepository.findById(brandId);
 			boolean exists = brandsRepository.existsById(brandId);
 			if (!exists) {
 				throw new IllegalStateException("Brand with id" + brandId + "does not exists.");
 				
 			}
 			 	brandsRepository.deleteById(brandId);			
 		}

 	// UPDATE CUSTOMER
 		
 		@Transactional
		public void updateBrand(Brands brand, long brandId) {
 			// brandsRepository.findById(brandId);
			Brands existingBrand = this.brandsRepository.findById(brandId)
					.orElseThrow(() -> new IllegalStateException("brand with id" + brandId + "does not exists."));
 			 
			if (brand.getBrandName() != null &&
				brand.getBrandName().length() > 0 &&
				!Objects.equals(brand.getBrandName(), existingBrand.getBrandName())) {
				existingBrand.setBrandName(brand.getBrandName());				
			}
			
		}

 		
}
 		
 		
	
//    // save brand
//	@PostMapping
//	public Brands createBrand(@RequestBody Brands brand) {
//        return this.brandsRepository.save(brand);
//    }
    
    // update brand
//	@PutMapping("/{id}")
// 	public Brands updateBrand(@RequestBody Brands brand, @PathVariable ("id") long brandId) {
// 		Brands existingBrand = this.brandsRepository.findById(brandId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + brandId));
// 		existingBrand.setFirstName(brand.getFirstName());
// 		existingBrand.setBrandId(brand.getBrandId());
// 		existingBrand.setCategoryId(brand.getCategoryId());
// 		existingBrand.setModelYear(brand.getModelYear());
// 		existingBrand.setListPrice(brand.getListPrice());
// 			return this.brandsRepository.save(existingBrand);
//    
//} 
 
 	// delete brand by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Brands> deleteBrand(@PathVariable ("id") long brandId) {
// 		Brands existingBrand = this.brandsRepository.findById(brandId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + brandId));
// 		this.brandsRepository.delete(existingBrand);
// 		return ResponseEntity.ok().build();
 //	}

