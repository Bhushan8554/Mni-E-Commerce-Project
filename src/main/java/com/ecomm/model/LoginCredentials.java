package com.ecomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginCredentials {

	private String mobileNumber;
	private String password;
	
}
