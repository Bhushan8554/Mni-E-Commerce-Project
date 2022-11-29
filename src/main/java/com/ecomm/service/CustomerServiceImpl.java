package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecomm.exception.CustomerException;
import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		//Customer customer=null;
		
		Optional<Customer> opt=customerDao.findById(id);
		
		if (opt.isEmpty()) {
			throw new CustomerException("No customer with ID = "+id+" found");
		}
		return opt.get();
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Customer c=null;
		
		Optional<Customer> opt=customerDao.findById(customer.getCustomerId());
		
		if (opt.isEmpty()) {
			throw new CustomerException("No customer found");
		}else {
			c=customerDao.save(customer);
		}
		return c;
	}

	@Override
	public Customer getCustomerByMobile(String mobile) throws CustomerException {
		Customer customer=null;
		
		customer=customerDao.findByMobileNo(mobile);
		
		if (customer==null) {
			throw new CustomerException("No customer with mobile no = "+mobile+" found");
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List< Customer> customers=new ArrayList<>();
		
		customers=customerDao.findAll();
		
		if(customers.size()==0) {
			throw new CustomerException("No customers in database");
		}
		
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		Customer c=customerDao.findByMobileNo(customer.getMobileNo());
		if(c!=null) {
			throw new CustomerException("Customer Already exist");
		}
		customer.setCart(new Cart(0.0, customer));
		customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
		customer.setRole("ROLE_USER");
		return customerDao.save(customer);
	}

	
}
