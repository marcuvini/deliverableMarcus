package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.OSF.deliverableMarcus.entity.OrderItems;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.OrderItemsRepository;


@Service
public class OrderItemsService {

	private ResourceExceptionHandler resExHand;
		
	private OrderItemsRepository orderItemsRepository;
	
	@Autowired
	public OrderItemsService(OrderItemsRepository orderItemsRepository) {
		super();
		this.orderItemsRepository = orderItemsRepository;
	}

	// GET ALL PRODUCTS
	
	public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }

	// GET PRODUCT BY ID
	
    public OrderItems getOrderItem(long id) {
        return orderItemsRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Order item not found"));
    }
 	
    // CREATE NEW PRODUCT
    
 		public void addNewOrderItem(OrderItems orderItem) {
		this.orderItemsRepository.save(orderItem);
	}
 		
 	// DELETE PRODUCT
 		
 		public void deleteOrderItem(long itemId) {
 			orderItemsRepository.findById(itemId);
 			boolean exists = orderItemsRepository.existsById(itemId);
 			if (!exists) {
 				throw new IllegalStateException("Order item with id" + itemId + "does not exists.");
 				
 			}
 			 	orderItemsRepository.deleteById(itemId);			
 		}

 	// UPDATE PRODUCT
 		
 		@Transactional
		public void updateOrderItem(OrderItems orderItem, long itemId) {
 			// orderItemsRepository.findById(itemId);
			OrderItems existingOrderItem = this.orderItemsRepository.findById(itemId)
					.orElseThrow(() -> new IllegalStateException("orderItem with id" + itemId + "does not exists."));
			
			if (orderItem.getOrderId() > 0 &&
					!Objects.equals(orderItem.getOrderId(), existingOrderItem.getOrderId())) {
						existingOrderItem.setOrderId(orderItem.getOrderId());				
			}
			

			if (orderItem.getProductId() > 0 &&
				!Objects.equals(orderItem.getProductId(), existingOrderItem.getProductId())) {
					existingOrderItem.setProductId(orderItem.getProductId());				
			}
			
			if (orderItem.getQuantity() > 0 &&
				!Objects.equals(orderItem.getQuantity(), existingOrderItem.getQuantity())) {
						existingOrderItem.setQuantity(orderItem.getQuantity());				
			}
			
			if (orderItem.getListPrice() > 0 &&
				!Objects.equals(orderItem.getListPrice(), existingOrderItem.getListPrice())) {
						existingOrderItem.setListPrice(orderItem.getListPrice());				
			}
			
			if (orderItem.getDiscount() >= 0 &&
				!Objects.equals(orderItem.getDiscount(), existingOrderItem.getDiscount())) {
						existingOrderItem.setDiscount(orderItem.getDiscount());				
			}
		}
}
 		

