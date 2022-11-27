package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String email;
	private String password;
	private Address add;
	
}
