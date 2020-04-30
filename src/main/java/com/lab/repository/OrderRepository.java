package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
