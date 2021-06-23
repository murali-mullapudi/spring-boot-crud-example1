package com.mine.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mine.training.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);

}
