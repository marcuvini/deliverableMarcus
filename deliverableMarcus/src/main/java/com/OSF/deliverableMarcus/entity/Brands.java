package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.brands")
public class Brands {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long brandId;
	
	@NonNull
	@Column(name = "brand_name")
	private String brandName;
	
	public Brands() {
		
	}

	public Brands(String brandName) {
		super();
		this.brandName = brandName;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
