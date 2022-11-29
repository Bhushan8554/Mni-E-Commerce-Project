package com.ecomm.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Customer_Order")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer o_id;
	
	private Double amount;
	
	private LocalDate date;
	
	
	
	public Order(Double amount, LocalDate date, OrderType orderType, List<Product> products) {
		super();
		this.amount = amount;
		this.date = date;
		this.orderType = orderType;
		this.products = products;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customerId" ,referencedColumnName = "customerId")
	Customer customer;

	@Enumerated
	private OrderType orderType;

	@Embedded
	private List<Product> products=new ArrayList<>();
	
	
	
}
