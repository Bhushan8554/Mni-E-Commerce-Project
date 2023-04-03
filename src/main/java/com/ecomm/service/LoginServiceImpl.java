package com.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ecomm.model.Customer;
import com.ecomm.model.LoginCredentials;
import com.ecomm.repository.CustomerDao;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	CustomerDao customerDao;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	 

	@Override
	public String login(LoginCredentials l) {
		
		Customer c=customerDao.findByMobileNo(l.getMobileNumber());
		if(c==null) {
			return "username not found";
		}
		if(!c.getPassword().equals(bCryptPasswordEncoder.encode(l.getPassword()))) {
			return "username invalid";
		}
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(l.getMobileNumber(),l.getPassword()));
		if(!isAuthenticated(authentication)) {
			return "Already Login Please logout first";
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "Login succecfull";
	}

	private boolean isAuthenticated(Authentication authentication) {
	    return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
	}
}
