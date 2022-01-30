package com.OSF.deliverableMarcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}

