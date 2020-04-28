package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
