package com.ecomm.service;

import java.util.List;

import com.ecomm.exception.CustomerException;
import com.ecomm.model.Customer;

public interface CustomerService {

	public Customer getCustomerById(Integer id) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer getCustomerByMobile(String mobile) throws CustomerException;
	
	public List<Customer> getAllCustomers() throws CustomerException;
	public Customer addAdminCustomer(Customer customer,String key) throws CustomerException;
}
