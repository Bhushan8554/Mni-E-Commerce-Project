package com.ecomm.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.CustomerException;
import com.ecomm.model.Customer;
import com.ecomm.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PermitAll()
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomerMapping(@RequestBody Customer customer) throws CustomerException{
		Customer c=customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@PermitAll
	@PostMapping("/admin/add")
	public ResponseEntity<Customer> addAdminMapping(@RequestParam("Auth_Key")String key,@RequestBody Customer customer) throws CustomerException{
		
		Customer c=customerService.addAdminCustomer(customer,key);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/customer")
	public ResponseEntity<Customer> ecomGetUserByIdMapping(@RequestParam("Customer_Id") Integer id) throws CustomerException{
		Customer c=customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/customer/mobile")
	public ResponseEntity<Customer> ecomGetUserByMobileMapping(@RequestParam("Customer_Mobile") String number) throws CustomerException{
		Customer c=customerService.getCustomerByMobile(number);
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> ecomGetAllUsersMapping() throws CustomerException{
		List<Customer> c=customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(c,HttpStatus.ACCEPTED);
		
	}
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("/update/customer")
	public ResponseEntity<Customer> ecomUpdateUserMapping(@RequestBody Customer c) throws CustomerException{
		Customer customer=customerService.updateCustomer(c);
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
		
	}
	
}
