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

import com.OSF.deliverableMarcus.entity.OrderItems;
import com.OSF.deliverableMarcus.service.OrderItemsService;

@RestController
@RequestMapping("/api/osf.order_items")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	@GetMapping(value = { "", "/" })
    public List<OrderItems> getOrderItem() {
        return this.orderItemsService.getAllOrderItems();
    }
	
	@PostMapping
	public void registerNewOrderItem(@RequestBody OrderItems orderItem) {
		orderItemsService.addNewOrderItem(orderItem);
	}
	
	@DeleteMapping(path= "{itemId}")
	public void deleteOrderItem(@PathVariable("itemId") Long itemId) {
		orderItemsService.deleteOrderItem(itemId);
	}
	
	@PutMapping(path= "{itemId}")
	public void updateOrderItem(@RequestBody OrderItems orderItem, @PathVariable("itemId") Long itemId) {
		orderItemsService.updateOrderItem(orderItem, itemId);
	}
	
	
//	
//	@PostMapping
//	public OrderItems createOrderItem(@RequestBody OrderItems orderItem) {
//        return this.orderItemsService.createOrderItem(orderItem);
//    }
}
