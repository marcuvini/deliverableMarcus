package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.stores")
public class Stores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long storeId;
	
	/*
	 * storeName
	 * phone - pode ser null
	 * email - pode ser null
	 * street - pode ser null
	 * city - pode ser null
	 * state - pode ser null
	 * zipCode - pode ser null
	 */
	
	
	@NonNull
	@Column(name = "store_name")
	private String storeName;
		
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
		
	@Column(name = "street")
	private String street;
		
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private String zipCode;
		
	public Stores() {
		
	}
	
	public Stores(String storeName, String phone, String email, String street, String city, String state,
			String zipCode) {
		super();
		this.storeName = storeName;
		this.phone = phone;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}




	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
	

	