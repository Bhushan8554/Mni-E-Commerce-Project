package com.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

	//public Cart getByCustomerId(Integer id);
}
