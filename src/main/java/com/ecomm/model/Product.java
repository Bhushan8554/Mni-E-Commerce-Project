package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@NotNull
	@Size(min = 3 )
	private String name;
	@NotNull
	@Size(min = 3 )
	private String discription;
	@NotNull
	@Size(min = 3 )
	private String brand;
	private String model;
	@NotNull
	@Pattern(regexp = "[0-5]{1}.[0-5]{1}")
	private String rating;
	@NotNull
	private Double price;
	@NotNull
	private Integer quantity;
	@Enumerated
	private Category category;
}
