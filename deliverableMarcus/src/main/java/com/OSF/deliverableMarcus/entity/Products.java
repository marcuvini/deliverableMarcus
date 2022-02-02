package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	/*
	 * productName
	 * brandId
	 * categoryId
	 * modelYear
	 * listPrice
	 */
	
	
	@NonNull
	@Column(name = "product_name")
	private String productName;
	
	@NonNull
	@Column(name = "brand_id")
	private long brandId;
	
	@NonNull
	@Column(name = "category_id")
	private int categoryId;
	
	@NonNull
	@Column(name = "model_year")
	private int modelYear;
	
	@NonNull
	@Column(name = "list_price")
	private double listPrice;
		
	public Products() {
		
	}
	
	public Products(String productName, int brandId, int categoryId, int modelYear, double listPrice) {
		super();
		this.productName = productName;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
	}

	
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

}

