package com.ecomm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.exception.CartException;
import com.ecomm.exception.CustomerException;
import com.ecomm.exception.ProductException;
import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Product;
import com.ecomm.repository.CartDao;
import com.ecomm.repository.CustomerDao;
import com.ecomm.repository.ProductDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ProductDao productDao;

	@Override
	public Cart getCartById(Integer id) throws CartException {
		Cart cart=null;
		
		cart=cartDao.getById(id);
		
		if (cart==null) {
			throw new CartException("No customer with ID = "+id+" found");
		}
		return cart;
	}

	@Override
	public Cart getCartByCustomer(Customer customer) throws CartException, CustomerException {
		Cart cart=null;
		
		Customer c=customerDao.getById(customer.getCustomerId());
		
		if(c==null) {
			throw new CustomerException("Customer Not found");
		}
				
		cart=cartDao.getByCustomerId(customer.getCustomerId());
		
		if (cart==null) {
			throw new CartException("No cart found");
		}
		return cart;
	}

	@Override
	public List<Product> addProductTOCart(Integer prod_id, Integer customer_Id) throws ProductException, CustomerException {
		Cart cart=customerDao.getById(customer_Id).getCart();
		if(cart==null) {
			throw new CustomerException("Customer not Exist");
		}
		
		Product p=productDao.getById(prod_id);
		if(p==null) {
			throw new ProductException("No such product Exist");
		}
		cart.getProductMap().add(p);
		
		cartDao.save(cart);
		return cart.getProductMap();
	}

	@Override
	public List<Product> RemoveProductFromCart(Integer prod_id, Integer customer_Id) throws CustomerException, ProductException {
		Cart cart=customerDao.getById(customer_Id).getCart();
		if(cart==null) {
			throw new CustomerException("Customer not Exist");
		}
		
		Product p=productDao.getById(prod_id);
		if(!cart.getProductMap().contains(p)) {
			throw new ProductException("No such product Exist");
		}
		cart.getProductMap().remove(p);
		
		cartDao.save(cart);
		return cart.getProductMap();
	}
	
	
}
