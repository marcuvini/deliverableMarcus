package com.OSF.deliverableMarcus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Staffs;

@Repository
public interface StaffsRepository extends JpaRepository<Staffs, Long>{

	Optional<Staffs> findStaffByEmail(String email);
	
	
}