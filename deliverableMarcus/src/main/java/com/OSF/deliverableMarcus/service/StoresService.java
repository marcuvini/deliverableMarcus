package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Stores;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.StoresRepository;


@Service
public class StoresService {

	private ResourceExceptionHandler resExHand;
	
	private StoresRepository storesRepository;
	
	@Autowired
	public StoresService(StoresRepository storesRepository) {
		super();
		this.storesRepository = storesRepository;
	}

	// GET ALL STORES
	
	public List<Stores> getAllStores() {
        return storesRepository.findAll();
    }

	// GET STORE BY ID
	
    public Stores getStore(long id) {
        return storesRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Store not found"));
    }
 	
    // CREATE NEW STORE
    
 		public void addNewStore(Stores store) {
		this.storesRepository.save(store);
	}
 		
 	// DELETE STORE
 		
 		public void deleteStore(long storeId) {
 			storesRepository.findById(storeId);
 			boolean exists = storesRepository.existsById(storeId);
 			if (!exists) {
 				throw new IllegalStateException("Store with id" + storeId + "does not exists.");
 				
 			}
 			 	storesRepository.deleteById(storeId);			
 		}

 	// UPDATE STORE
 		
 		@Transactional
		public void updateStore(Stores store, long storeId) {
 			// storesRepository.findById(storeId);
			Stores existingStore = this.storesRepository.findById(storeId)
					.orElseThrow(() -> new IllegalStateException("store with id" + storeId + "does not exists."));
 			 
			if (store.getStoreName() != null &&
				store.getStoreName().length() > 0 &&
				!Objects.equals(store.getStoreName(), existingStore.getStoreName())) {
				existingStore.setStoreName(store.getStoreName());				
			}
			
		
			if (store.getPhone() != null &&
					store.getPhone().length() > 0 &&
					!Objects.equals(store.getPhone(), existingStore.getPhone())) {
					existingStore.setPhone(store.getPhone());				
			}
			
			if (store.getEmail() != null &&
					store.getEmail().length() > 0 &&
					!Objects.equals(store.getEmail(), existingStore.getEmail())) {
					existingStore.setEmail(store.getEmail());				
			}
			
			if (store.getStreet() != null &&
					store.getStreet().length() > 0 &&
					!Objects.equals(store.getStreet(), existingStore.getStreet())) {
					existingStore.setStreet(store.getStreet());				
			}
			
			if (store.getCity() != null &&
					store.getCity().length() > 0 &&
					!Objects.equals(store.getCity(), existingStore.getCity())) {
					existingStore.setCity(store.getCity());				
			}
			
			if (store.getState() != null &&
					store.getState().length() > 0 &&
					!Objects.equals(store.getState(), existingStore.getState())) {
					existingStore.setState(store.getState());				
			}
			
			if (store.getZipCode() != null &&
					store.getZipCode().length() > 0 &&
					!Objects.equals(store.getZipCode(), existingStore.getZipCode())) {
					existingStore.setZipCode(store.getZipCode());				
			}
		}

 		
}
 		
 		
	
//    // save store
//	@PostMapping
//	public Stores createStore(@RequestBody Stores store) {
//        return this.storesRepository.save(store);
//    }
    
    // update store
//	@PutMapping("/{id}")
// 	public Stores updateStore(@RequestBody Stores store, @PathVariable ("id") long storeId) {
// 		Stores existingStore = this.storesRepository.findById(storeId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + storeId));
// 		existingStore.setStoreName(store.getStoreName());
// 		existingStore.setBrandId(store.getBrandId());
// 		existingStore.setCategoryId(store.getCategoryId());
// 		existingStore.setModelYear(store.getModelYear());
// 		existingStore.setListPrice(store.getListPrice());
// 			return this.storesRepository.save(existingStore);
//    
//} 
 
 	// delete store by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Stores> deleteStore(@PathVariable ("id") long storeId) {
// 		Stores existingStore = this.storesRepository.findById(storeId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + storeId));
// 		this.storesRepository.delete(existingStore);
// 		return ResponseEntity.ok().build();
 //	}


