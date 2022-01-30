package com.OSF.deliverableMarcus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Long>{

}