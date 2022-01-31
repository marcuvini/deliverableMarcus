package com.OSF.deliverableMarcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long>{

}
