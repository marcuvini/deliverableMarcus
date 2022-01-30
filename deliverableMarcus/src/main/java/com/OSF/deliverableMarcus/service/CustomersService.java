package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Customers;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.CustomersRepository;


@Service
public class CustomersService {

	private ResourceExceptionHandler resExHand;
		
	private CustomersRepository customersRepository;
	
	@Autowired
	public CustomersService(CustomersRepository customersRepository) {
		super();
		this.customersRepository = customersRepository;
	}

	// GET ALL CUSTOMERS
	
	public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

	// GET CUSTOMER BY ID
	
    public Customers getCustomer(long id) {
        return customersRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Customer not found"));
    }
 	
    // CREATE NEW CUSTOMER
    
 		public void addNewCustomer(Customers customer) {
		this.customersRepository.save(customer);
	}
 		
 	// DELETE CUSTOMER
 		
 		public void deleteCustomer(long customerId) {
 			customersRepository.findById(customerId);
 			boolean exists = customersRepository.existsById(customerId);
 			if (!exists) {
 				throw new IllegalStateException("Customer with id" + customerId + "does not exists.");
 				
 			}
 			 	customersRepository.deleteById(customerId);			
 		}

 	// UPDATE CUSTOMER
 		
 		@Transactional
		public void updateCustomer(Customers customer, long customerId) {
 			// customersRepository.findById(customerId);
			Customers existingCustomer = this.customersRepository.findById(customerId)
					.orElseThrow(() -> new IllegalStateException("customer with id" + customerId + "does not exists."));
 			 
			if (customer.getFirstName() != null &&
				customer.getFirstName().length() > 0 &&
				!Objects.equals(customer.getFirstName(), existingCustomer.getFirstName())) {
				existingCustomer.setFirstName(customer.getFirstName());				
			}
			
			if (customer.getLastName() != null &&
					customer.getLastName().length() > 0 &&
					!Objects.equals(customer.getLastName(), existingCustomer.getLastName())) {
					existingCustomer.setLastName(customer.getLastName());				
			}
			
			if (customer.getPhone() != null &&
					customer.getPhone().length() > 0 &&
					!Objects.equals(customer.getPhone(), existingCustomer.getPhone())) {
					existingCustomer.setPhone(customer.getPhone());				
			}
			
			if (customer.getEmail() != null &&
					customer.getEmail().length() > 0 &&
					!Objects.equals(customer.getEmail(), existingCustomer.getEmail())) {
					existingCustomer.setEmail(customer.getEmail());				
			}
			
			if (customer.getStreet() != null &&
					customer.getStreet().length() > 0 &&
					!Objects.equals(customer.getStreet(), existingCustomer.getStreet())) {
					existingCustomer.setStreet(customer.getStreet());				
			}
			
			if (customer.getCity() != null &&
					customer.getCity().length() > 0 &&
					!Objects.equals(customer.getCity(), existingCustomer.getCity())) {
					existingCustomer.setCity(customer.getCity());				
			}
			
			if (customer.getState() != null &&
					customer.getState().length() > 0 &&
					!Objects.equals(customer.getState(), existingCustomer.getState())) {
					existingCustomer.setState(customer.getState());				
			}
			
			if (customer.getZipCode() != null &&
					customer.getZipCode().length() > 0 &&
					!Objects.equals(customer.getZipCode(), existingCustomer.getZipCode())) {
					existingCustomer.setZipCode(customer.getZipCode());				
			}
		}

 		
}
 		
 		
	
//    // save customer
//	@PostMapping
//	public Customers createCustomer(@RequestBody Customers customer) {
//        return this.customersRepository.save(customer);
//    }
    
    // update customer
//	@PutMapping("/{id}")
// 	public Customers updateCustomer(@RequestBody Customers customer, @PathVariable ("id") long customerId) {
// 		Customers existingCustomer = this.customersRepository.findById(customerId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + customerId));
// 		existingCustomer.setFirstName(customer.getFirstName());
// 		existingCustomer.setBrandId(customer.getBrandId());
// 		existingCustomer.setCategoryId(customer.getCategoryId());
// 		existingCustomer.setModelYear(customer.getModelYear());
// 		existingCustomer.setListPrice(customer.getListPrice());
// 			return this.customersRepository.save(existingCustomer);
//    
//} 
 
 	// delete customer by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Customers> deleteCustomer(@PathVariable ("id") long customerId) {
// 		Customers existingCustomer = this.customersRepository.findById(customerId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + customerId));
// 		this.customersRepository.delete(existingCustomer);
// 		return ResponseEntity.ok().build();
 //	}

