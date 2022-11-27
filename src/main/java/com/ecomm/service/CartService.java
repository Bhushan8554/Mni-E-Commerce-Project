package com.ecomm.service;

import java.util.List;

import com.ecomm.exception.CartException;
import com.ecomm.exception.CustomerException;
import com.ecomm.exception.ProductException;
import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Product;


public interface CartService{

	
	public Cart getCartById(Integer id) throws CartException;
	
	public Cart getCartByCustomer(Customer customer) throws CartException, CustomerException;
	
	public List<Product> addProductTOCart(Integer prod_id,Integer cart_id ) throws ProductException, CustomerException;
	
	public List<Product> RemoveProductFromCart(Integer prod_id,Integer cart_id ) throws CustomerException, ProductException;
}
