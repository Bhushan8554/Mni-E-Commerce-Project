package com.ecomm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double totalAmount;
	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	private Customer customer;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private java.util.List<Product> productMap= new ArrayList<>();
	
	
}
