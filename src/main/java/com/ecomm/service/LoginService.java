package com.ecomm.service;

import org.springframework.stereotype.Service;

import com.ecomm.model.LoginCredentials;

@Service
public interface LoginService {

	public String login(LoginCredentials l);
}
