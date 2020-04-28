package com.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.domain.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

}
