package com.OSF.deliverableMarcus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "osf.categorys")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	@NonNull
	@Column(name = "category_name")
	private String categoryName;
	
	public Categories() {
		
	}

	public Categories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}