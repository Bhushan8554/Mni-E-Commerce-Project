package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.exception.CustomerException;
import com.ecomm.exception.OrderException;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.OrderType;
import com.ecomm.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;
	@PreAuthorize("hasRole('USER')")
	@PostMapping("user/customer")
	public ResponseEntity<List<Order>> getOrdersByCustomerMapping(@RequestBody Customer customer) throws OrderException{
		List<Order> list=orderService.getOrdersByCustomer(customer);
		return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/allorders")
	public ResponseEntity<List<Order>> getAllOrdersMapping() throws OrderException{
		List<Order> list=orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('USER')")
	@PostMapping("user/add")
	public ResponseEntity<Order> addOrderMapping(@RequestParam("Customer_Id")Integer id) throws OrderException, CustomerException{
		Order o=orderService.addOrder(id);
		return new ResponseEntity<Order>(o,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update")
	public ResponseEntity<Order> updateOrderMapping(@RequestBody Order order) throws OrderException, CustomerException{
		Order o=orderService.updateOrder(order);
		return new ResponseEntity<Order>(o,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/orderid")
	public ResponseEntity<Order> getOrderByIdMapping(@RequestParam("order_id")Integer id) throws OrderException, CustomerException{
		Order o=orderService.getOrderByID(id);
		return new ResponseEntity<Order>(o,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/type")
	public ResponseEntity<List<Order>> getAllOrdersByTypeMapping(@RequestBody OrderType orderType) throws OrderException{
		List<Order> list=orderService.getAllOrderByType(orderType);
		return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
	}
}
