package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.order_items")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	/*
	 * productName
	 * brandId
	 * categoryId
	 * modelYear
	 * listPrice
	 */
	
	@NonNull
	@Column(name = "order_id")
	private int orderId;
	
	@NonNull
	@Column(name = "product_id")
	private int productId;
	
	@NonNull
	@Column(name = "quantity")
	private int quantity;
	
	@NonNull
	@Column(name = "list_price")
	private double listPrice;
	
	@NonNull
	@Column(name = "discount")
	private double discount;

	
	public OrderItems() {
		
	}


	public OrderItems(int orderId, int productId, int quantity, double listPrice, double discount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.discount = discount;
	}


	public long getItemId() {
		return itemId;
	}


	public void setItemId(long itemId) {
		this.itemId = itemId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getListPrice() {
		return listPrice;
	}


	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}
	

}

