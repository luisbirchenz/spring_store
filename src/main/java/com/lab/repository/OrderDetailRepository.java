package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
