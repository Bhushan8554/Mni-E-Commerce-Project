package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
