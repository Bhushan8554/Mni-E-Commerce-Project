package com.ecomm.service;

import com.ecomm.model.Customer;

public interface CustomerService {

	public void getCustomerById(Integer id);
	
	public void updateCustomer(Customer customer);
	
	public void getCustomerByMobile(String mobile);
	
	public void getAllCustomers();
}
