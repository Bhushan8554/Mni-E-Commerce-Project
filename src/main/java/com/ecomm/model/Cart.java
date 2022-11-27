package com.ecomm.model;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private List<Product> productMap= new ArrayList<>();
	
	
}
