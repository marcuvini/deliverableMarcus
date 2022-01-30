
package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	/*
	 * orderName
	 * brandId
	 * categoryId
	 * modelYear
	 * listPrice
	 */
	
	@Column(name = "customer_id")
	private int customerId;
	
	@NonNull
	@Column(name = "order_status")
	private int orderStatus;
	
	@NonNull
	@Column(name = "order_date")
	private String orderDate;

	@NonNull
	@Column(name = "required_date")
	private String requiredDate;
	
	@NonNull
	@Column(name = "shipped_date")
	private String shippedDate;
	
	@Column(name = "store_id") // RELACIONAR COM LOJA
	private int storeId;
	
	@NonNull
	@Column(name = "staff_id")
	private int staffId;
	
	public Orders() {
		
	}
	
	
	public Orders(int customerId, int orderStatus, String orderDate, String requiredDate, String shippedDate,
			int storeId, int staffId) {
		super();
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.storeId = storeId;
		this.staffId = staffId;
	}


	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
	
	
	
}