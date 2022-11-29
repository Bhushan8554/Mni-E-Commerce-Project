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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@NotNull
	@Size(min = 3, message = "Please Enter the valid name")
	private String name;
	@Pattern(regexp = "[789]{1}\\d{9}" , message = "Mobile number is not valid")
	@NotNull
	private String mobileNo;
	@Email
	@NotNull
	private String email;
	@NotNull
	
	private String password;
	private String role;
	
	@Embedded
	private Address add;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> orderList=new ArrayList<>();
	
}
