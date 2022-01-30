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

import com.OSF.deliverableMarcus.entity.Customers;
import com.OSF.deliverableMarcus.service.CustomersService;

@RestController
@RequestMapping("/api/osf.customers")
public class CustomersController {
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping(value = { "", "/" })
    public List<Customers> getCustomer() {
        return this.customersService.getAllCustomers();
    }
	
	@PostMapping
	public void registerNewCustomer(@RequestBody Customers customer) {
		customersService.addNewCustomer(customer);
	}
	
	@DeleteMapping(path= "{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Long customerId) {
		customersService.deleteCustomer(customerId);
	}
	
	@PutMapping(path= "{customerId}")
	public void updateCustomer(@RequestBody Customers customer, @PathVariable("customerId") Long customerId) {
		customersService.updateCustomer(customer, customerId);
	}
	
}