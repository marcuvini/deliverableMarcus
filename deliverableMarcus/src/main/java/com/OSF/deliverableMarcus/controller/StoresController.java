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

import com.OSF.deliverableMarcus.entity.Stores;
import com.OSF.deliverableMarcus.service.StoresService;

@RestController
@RequestMapping("/api/osf.stores")
public class StoresController {
	
	@Autowired
	private StoresService storesService;
	
	@GetMapping(value = { "", "/" })
    public List<Stores> getStore() {
        return this.storesService.getAllStores();
    }
	
	@PostMapping
	public void registerNewStore(@RequestBody Stores store) {
		storesService.addNewStore(store);
	}
	
	@DeleteMapping(path= "{storeId}")
	public void deleteStore(@PathVariable("storeId") Long storeId) {
		storesService.deleteStore(storeId);
	}
	
	@PutMapping(path= "{storeId}")
	public void updateStore(@RequestBody Stores store, @PathVariable("storeId") Long storeId) {
		storesService.updateStore(store, storeId);
	}
	
}