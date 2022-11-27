package com.ecomm.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.exception.CustomerException;
import com.ecomm.exception.OrderException;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.OrderType;

public interface OrderService{

	 public List<Order> getOrdersByCustomer(Customer customer) throws OrderException;
	 
	 public List<Order> getAllOrders() throws OrderException;
	 
	 public Order addOrder(Integer customerId)throws OrderException, CustomerException;
	 public Order updateOrder(Order order) throws OrderException;
	
	 public Order getOrderByID(Integer id) throws OrderException;

	List<Order> getAllOrderByType(OrderType orderType) throws OrderException;
}
