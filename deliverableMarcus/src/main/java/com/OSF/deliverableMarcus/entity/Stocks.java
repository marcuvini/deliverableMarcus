package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.categorys")
public class Stocks {
	
	@Id
	@NonNull
	@Column(name = "store_id")
	private Long storeId;
	
	@NonNull
	@Column(name = "product_id")
	private int productId;

	@Column(name = "quantity")
	private int quantity;
	
	public Stocks() {
		
	}
	
	public Stocks(Long storeId, int productId, int quantity) {
		super();
		this.storeId = storeId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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



}