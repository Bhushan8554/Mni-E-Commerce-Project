package com.ecomm.controller;

import java.util.List;

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

import com.ecomm.exception.CartException;
import com.ecomm.exception.CustomerException;
import com.ecomm.exception.ProductException;
import com.ecomm.model.Cart;
import com.ecomm.model.Customer;
import com.ecomm.model.Product;
import com.ecomm.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/cartid")
	public ResponseEntity<Cart> getCartDetailsMapping(@RequestParam("cart_id") Integer id) throws CartException{
		Cart cart=cartService.getCartById(id);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/add")
	public ResponseEntity<List<Product>> addProductInCartMapping(@RequestParam("product_Id") Integer pId,@RequestParam("Customer_Id")Integer cId) throws ProductException, CustomerException{
		List<Product> pList=cartService.addProductTOCart(pId, cId);
		return new ResponseEntity<List<Product>>(pList,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/remove")
	public ResponseEntity<List<Product>> removeProductInCartMapping(@RequestParam("product_Id") Integer pId,@RequestParam("Customer_Id")Integer cId) throws ProductException, CustomerException{
		List<Product> pList=cartService.RemoveProductFromCart(pId, cId);
		return new ResponseEntity<List<Product>>(pList,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/customer")
	public ResponseEntity<Cart> getCartDetailsByCustomerMapping(@RequestBody Customer customer) throws CartException, CustomerException{
		Cart cart=cartService.getCartByCustomer(customer);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
}
