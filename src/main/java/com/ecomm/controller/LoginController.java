package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.model.LoginCredentials;
import com.ecomm.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(LoginCredentials l){
		
		return new  ResponseEntity<String>(loginService.login(l),HttpStatus.OK);
	}
}
