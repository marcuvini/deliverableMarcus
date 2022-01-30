package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.staffs")
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long staffId;
	

	@NonNull
	@Column(name = "first_name")
	private String firstName;
	
	@NonNull
	@Column(name = "last_name")
	private String lastName;
	
	@NonNull
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@NonNull	
	@Column(name = "active")
	private int active;
	
	@NonNull
	@Column(name = "storeId")
	private int storeId;
	
	@Column(name = "managerId")
	private int managerId;
	
	public Staff() {
		
	}
	
	
	public Staff(String firstName, String lastName, String email, String phone, int active, int storeId,
			int managerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.active = active;
		this.storeId = storeId;
		this.managerId = managerId;
	}




	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



}
	
	

	

	