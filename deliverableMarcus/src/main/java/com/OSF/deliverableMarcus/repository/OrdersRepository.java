package com.OSF.deliverableMarcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
