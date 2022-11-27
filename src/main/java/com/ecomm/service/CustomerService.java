package com.ecomm.service;

import java.util.List;

import com.ecomm.model.Customer;

public interface CustomerService {

	public Customer getCustomerById(Integer id);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer getCustomerByMobile(String mobile);
	
	public List<Customer> getAllCustomers();
}
