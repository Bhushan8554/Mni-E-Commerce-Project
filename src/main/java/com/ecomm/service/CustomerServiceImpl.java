package com.ecomm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.exception.CustomerException;
import com.ecomm.model.Customer;
import com.ecomm.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		Customer customer=null;
		
		customer=customerDao.getById(id);
		
		if (customer==null) {
			throw new CustomerException("No customer with ID = "+id+" found");
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Customer c=null;
		
		c=customerDao.getById(customer.getCustomerId());
		
		if (c==null) {
			throw new CustomerException("No customer found");
		}else {
			c=customerDao.save(customer);
		}
		return c;
	}

	@Override
	public Customer getCustomerByMobile(String mobile) throws CustomerException {
		Customer customer=null;
		
		customer=customerDao.getByMobileNo(mobile);
		
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

	
}
