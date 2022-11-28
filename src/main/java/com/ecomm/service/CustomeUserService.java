package com.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecomm.model.CustomeUserDetails;
import com.ecomm.model.Customer;
import com.ecomm.repository.CustomerDao;

@Service
public class CustomeUserService implements UserDetailsService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer=null;
		customer=this.customerDao.findByMobileNo(username);
		if(customer==null) {
			throw new UsernameNotFoundException("No customer Exist");
		}
		
		// TODO Auto-generated method stub
		return new CustomeUserDetails(customer);
	}

}
