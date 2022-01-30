package com.OSF.deliverableMarcus.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Orders;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.OrdersRepository;


@Service
public class OrdersService {

	private ResourceExceptionHandler resExHand;
		
	private OrdersRepository ordersRepository;
	
	@Autowired
	public OrdersService(OrdersRepository ordersRepository) {
		super();
		this.ordersRepository = ordersRepository;
	}

	// GET ALL ORDERS
	
	public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

	// GET ORDER BY ID
	
    public Orders getOrder(long id) {
        return ordersRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Order not found"));
    }
 	
    // CREATE NEW ORDER
    
    	// verificar se existe store_id
    	// verificar se existe staff_id
    
 		public void addNewOrder(Orders order) {
		this.ordersRepository.save(order);
	}
 		
 	// DELETE ORDER 
 		
 		public void deleteOrder(long orderId) {
 			ordersRepository.findById(orderId);
 			boolean exists = ordersRepository.existsById(orderId);
 			if (!exists) {
 				throw new IllegalStateException("Order with id" + orderId + "does not exists.");
 				
 			}
 			 	ordersRepository.deleteById(orderId);			
 		}

 	// UPDATE ORDER
 		
 		@Transactional
		public void updateOrder(Orders order, long orderId) {
 			// ordersRepository.findById(orderId);
			Orders existingOrder = this.ordersRepository.findById(orderId)
					.orElseThrow(() -> new IllegalStateException("order with id" + orderId + "does not exists."));
 			
			// int
			
			if (order.getCustomerId() > 0 &&
					!Objects.equals(order.getCustomerId(), existingOrder.getCustomerId())) {
						existingOrder.setCustomerId(order.getCustomerId());	
			}
			
			// int
			
			if (order.getOrderStatus() > 0 &&
					!Objects.equals(order.getOrderStatus(), existingOrder.getOrderStatus())) {
						existingOrder.setOrderStatus(order.getOrderStatus());	
			}

			// string - modificar para formato data (?)
			
			if (order.getOrderDate() != null &&
					order.getOrderDate().length() > 0 &&
					!Objects.equals(order.getOrderDate(), existingOrder.getOrderDate())) {
					existingOrder.setOrderDate(order.getOrderDate());				
			}

			// string - modificar para formato data (?)
			
			if (order.getRequiredDate() != null &&
					order.getRequiredDate().length() > 0 &&
					!Objects.equals(order.getRequiredDate(), existingOrder.getRequiredDate())) {
					existingOrder.setRequiredDate(order.getRequiredDate());				
			}

			// string - modificar para formato data (?)
			
			if (order.getShippedDate() != null &&
					order.getShippedDate().length() > 0 &&
					!Objects.equals(order.getShippedDate(), existingOrder.getShippedDate())) {
					existingOrder.setShippedDate(order.getShippedDate());				
			}

			// int
			
			if (order.getStoreId() > 0 &&
					!Objects.equals(order.getStoreId(), existingOrder.getStoreId())) {
						existingOrder.setStoreId(order.getStoreId());	
			}
			// int
			
			if (order.getStaffId() > 0 &&
					!Objects.equals(order.getStaffId(), existingOrder.getStaffId())) {
						existingOrder.setStaffId(order.getStaffId());	
			}

			
		}

 		
}
 		
 		
	
//    // save order
//	@PostMapping
//	public Orders createOrder(@RequestBody Orders order) {
//        return this.ordersRepository.save(order);
//    }
    
    // update order
//	@PutMapping("/{id}")
// 	public Orders updateOrder(@RequestBody Orders order, @PathVariable ("id") long orderId) {
// 		Orders existingOrder = this.ordersRepository.findById(orderId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + orderId));
// 		existingOrder.setFirstName(order.getFirstName());
// 		existingOrder.setBrandId(order.getBrandId());
// 		existingOrder.setCategoryId(order.getCategoryId());
// 		existingOrder.setModelYear(order.getModelYear());
// 		existingOrder.setListPrice(order.getListPrice());
// 			return this.ordersRepository.save(existingOrder);
//    
//} 
 
 	// delete order by id
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Orders> deleteOrder(@PathVariable ("id") long orderId) {
// 		Orders existingOrder = this.ordersRepository.findById(orderId)
// 				.orElseThrow(() -> resExHand.new ResourceNotFoundException("User not found with id: " + orderId));
// 		this.ordersRepository.delete(existingOrder);
// 		return ResponseEntity.ok().build();
 //	}

