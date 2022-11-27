package com.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.model.Customer;
import com.ecomm.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
