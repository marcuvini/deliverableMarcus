package com.OSF.deliverableMarcus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long>{

	Optional<Brands> findBrandByBrandId(long brandId);
	
}
