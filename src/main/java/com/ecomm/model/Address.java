package com.ecomm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Size(min = 3, message = "Please Enter the valid city")
	@NotNull
	private String city;
	@Size(min = 3, message = "Please Enter the valid state")
	@NotNull
	private String state;
	@Size(min = 3, message = "Please Enter the valid country")
	@NotNull
	private String country;
	@Pattern(regexp = "[1-9]{6}")
	@NotNull
	private String pincode;
	@NotNull
	private Double houseNo;
	
	
	
}
