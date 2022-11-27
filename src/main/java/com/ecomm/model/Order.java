package com.ecomm.model;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

	private Integer orderId;
	private LocalDate date;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Customer customer;
	@OneToMany(cascade = CascadeType.PERSIST)
	private HashMap<Product, Integer> prodMap=new HashMap<>();
}
