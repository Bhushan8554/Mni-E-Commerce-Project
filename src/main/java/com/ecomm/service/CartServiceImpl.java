package com.ecomm.service;

import java.util.List;
import java.util.Optional;

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
		
		Optional<Cart> opt=cartDao.findById(id);
		
		if (opt.isEmpty()) {
			throw new CartException("No customer with ID = "+id+" found");
		}
		return opt.get();
	}

	@Override
	public Cart getCartByCustomer(Customer customer) throws CartException, CustomerException {
		Cart cart=null;
		
		Optional< Customer> opt1=customerDao.findById(customer.getCustomerId());
		
		if(opt1.isEmpty()) {
			throw new CustomerException("Customer Not found");
		}
		
		Optional< Cart> opt=cartDao.findById(customer.getCustomerId());
		
		if (opt.isEmpty()) {
			throw new CartException("No cart found");
		}
		return opt.get();
	}

	@Override
	public List<Product> addProductTOCart(Integer prod_id, Integer customer_Id) throws ProductException, CustomerException {
		Optional< Customer> opt1=customerDao.findById(customer_Id);
		
		if(opt1.isEmpty()) {
			throw new CustomerException("Customer Not found");
		}
		
		
		Optional< Product> opt2=productDao.findById(prod_id);
		if(opt2.isEmpty()) {
			throw new ProductException("No such product Exist");
		}
		Cart cart=opt1.get().getCart();
		if(cart==null) {
			cart=new Cart();
		}
		List<Product> s= cart.getProductMap();
		s.add(opt2.get());
		Double amount=0.0;
		for (int i=0;i<s.size();i++) {
			amount+=s.get(i).getPrice();
		}
		
		cart.setTotalAmount(amount);
		cart.setProductMap(s);
		cartDao.save(cart);
		return cart.getProductMap();
	}
	
	

	@Override
	public List<Product> RemoveProductFromCart(Integer prod_id, Integer customer_Id) throws CustomerException, ProductException {
		Optional<Customer> opt=customerDao.findById(customer_Id);
		if(opt.isEmpty()) {
			throw new CustomerException("Customer not Exist");
		}
		
		 Cart cart=opt.get().getCart();
		
		Optional<Product> opt2=productDao.findById(prod_id);
		Product p=opt2.get();
		if(!cart.getProductMap().contains(p)) {
			throw new ProductException("No such product Exist");
		}
		cart.setTotalAmount(cart.getTotalAmount()-p.getPrice());
		cart.getProductMap().remove(p);
		
		cartDao.save(cart);
		return cart.getProductMap();
	}
	
	
}
