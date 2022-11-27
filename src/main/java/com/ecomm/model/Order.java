package com.ecomm.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Embedded
	private List<Product> products=new ArrayList<>();
	
	
	
}
