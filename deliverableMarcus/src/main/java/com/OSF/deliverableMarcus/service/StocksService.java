package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Stocks;
import com.OSF.deliverableMarcus.repository.StocksRepository;


@Service
public class StocksService {
		
	private StocksRepository stocksRepository;
	
	@Autowired
	public StocksService(StocksRepository stocksRepository) {
		super();
		this.stocksRepository = stocksRepository;
	}

	// GET ALL STOCKS
	
	public List<Stocks> getAllStocks() {
        return stocksRepository.findAll();
    }

	// GET STOCK BY ID
	
    public Stocks getStock(Long id) {
        return stocksRepository
          .findById(id)
          .orElseThrow(() -> new IllegalStateException("Stock not found"));
    }
 	
    // CREATE NEW STOCK
    
 		public void addNewStock(Stocks stock) {
		this.stocksRepository.save(stock);
	}
 		
 	// DELETE STOCK
 		
 		public void deleteStock(long storeId) {
 			stocksRepository.findById(storeId);
 			boolean exists = stocksRepository.existsById(storeId);
 			if (!exists) {
 				throw new IllegalStateException("Stock with id" + storeId + "does not exists.");
 				
 			}
 			 	stocksRepository.deleteById(storeId);			
 		}

 	// UPDATE STOCK
 		
 		@Transactional
		public void updateStock(Stocks stock, long storeId) {
 			// stocksRepository.findById(stockId);
			Stocks existingStock = this.stocksRepository.findById(storeId)
					.orElseThrow(() -> new IllegalStateException("stock with id" + storeId + "does not exists."));
 			 
			if (stock.getProductId() >= 0 &&
					!Objects.equals(stock.getProductId(), existingStock.getProductId())) {
							existingStock.setProductId(stock.getProductId());				
			}
			
			if (stock.getQuantity() >= 0 &&
					!Objects.equals(stock.getQuantity(), existingStock.getQuantity())) {
							existingStock.setQuantity(stock.getQuantity());				
			}
			
			
		}

 		
}
 		
 		
	
//    // save stock
//	@PostMapping
//	public Stocks createStock(@RequestBody Stocks stock) {
//        return this.stocksRepository.save(stock);
//    }
    
    // update stock
//	@PutMapping("/{id}")
// 	public Stocks updateStock(@RequestBody Stocks stock, @PathVariable ("id") long stockId) {
// 		Stocks existingStock = this.stocksRepository.findById(stockId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + stockId));
// 		existingStock.setFirstName(stock.getFirstName());
// 		existingStock.setStockId(stock.getStockId());
// 		existingStock.setCategoryId(stock.getCategoryId());
// 		existingStock.setModelYear(stock.getModelYear());
// 		existingStock.setListPrice(stock.getListPrice());
// 			return this.stocksRepository.save(existingStock);
//    
//} 
 
 	// delete stock by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Stocks> deleteStock(@PathVariable ("id") long stockId) {
// 		Stocks existingStock = this.stocksRepository.findById(stockId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + stockId));
// 		this.stocksRepository.delete(existingStock);
// 		return ResponseEntity.ok().build();
 //	}

