package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
