package com.OSF.deliverableMarcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>{

}