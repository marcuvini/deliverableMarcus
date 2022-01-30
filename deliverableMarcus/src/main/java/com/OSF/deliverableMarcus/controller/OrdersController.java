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

import com.OSF.deliverableMarcus.entity.Orders;
import com.OSF.deliverableMarcus.service.OrdersService;

@RestController
@RequestMapping("/api/osf.orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping(value = { "", "/" })
    public List<Orders> getOrder() {
        return this.ordersService.getAllOrders();
    }
	
	@PostMapping
	public void registerNewOrder(@RequestBody Orders order) {
		ordersService.addNewOrder(order);
	}
	
	@DeleteMapping(path= "{orderId}")
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		ordersService.deleteOrder(orderId);
	}
	
	@PutMapping(path= "{orderId}")
	public void updateOrder(@RequestBody Orders order, @PathVariable("orderId") Long orderId) {
		ordersService.updateOrder(order, orderId);
	}
	
}