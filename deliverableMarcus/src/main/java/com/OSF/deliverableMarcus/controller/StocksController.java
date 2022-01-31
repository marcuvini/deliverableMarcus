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

import com.OSF.deliverableMarcus.entity.Stocks;
import com.OSF.deliverableMarcus.service.StocksService;

@RestController
@RequestMapping("/api/osf.stocks")
public class StocksController {
	
	@Autowired
	private StocksService stocksService;
	
	@GetMapping(value = { "", "/" })
    public List<Stocks> getStock() {
        return this.stocksService.getAllStocks();
    }
	
	@GetMapping(value = {"/{id}"})
    public Stocks getStockById(@PathVariable (value = "id") long storeId) {
        return this.stocksService.getStock(storeId);
    }
	
	@PostMapping
	public void registerNewStock(@RequestBody Stocks stock) {
		stocksService.addNewStock(stock);
	}
	
	@DeleteMapping(path= "{storeId}")
	public void deleteStock(@PathVariable("storeId") int storeId) {
		stocksService.deleteStock(storeId);
	}
	
	@PutMapping(path= "{storeId}")
	public void updateStock(@RequestBody Stocks stock, @PathVariable("storeId") int storeId) {
		stocksService.updateStock(stock, storeId);
	}
	
}