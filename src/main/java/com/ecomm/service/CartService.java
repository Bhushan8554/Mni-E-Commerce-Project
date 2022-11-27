package com.ecomm.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Product;

public interface CartService extends JpaRepository<Cart, Integer>{

	
	public Cart getCartById(Integer id);
	
	public Cart getCartByCustomer(Customer customer);
	
	public List<Product> addProductTOCart(Integer prod_id,Integer cart_id );
	
	public List<Product> RemoveProductFromCart(Integer prod_id,Integer cart_id );
}
