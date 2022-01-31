package com.OSF.deliverableMarcus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSF.deliverableMarcus.entity.Stocks;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long>{

}
