package com.ecomm.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String email;
	private String password;
	
	@Embedded
	private Address add;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.PERSIST)
	private Cart cart;
	
//	@OneToMany(cascade = CascadeType.PERSIST)
//	private List<Order> orderList=new ArrayList<>();
	
}
