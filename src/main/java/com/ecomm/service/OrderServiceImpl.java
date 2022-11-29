package com.ecomm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecomm.exception.CustomerException;
import com.ecomm.exception.OrderException;
import com.ecomm.model.CustomeUserDetails;
import com.ecomm.model.Customer;
import com.ecomm.model.Order;
import com.ecomm.model.OrderType;
import com.ecomm.model.Product;
import com.ecomm.repository.CustomerDao;
import com.ecomm.repository.OrderDao;
import com.ecomm.repository.ProductDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Autowired 
	CustomerDao customerDao;
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Order> getOrdersByCustomer(Customer customer) throws OrderException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof Customer) {
			System.out.println("Yes");
		}
		List<Order> list=new ArrayList<>();
				list=orderDao.findAll();
		
		if(list.size()==0) {
			throw new OrderException("No order found");
		}
		
		return list;
	}

	@Override
	public List<Order> getAllOrders() throws OrderException {
		List<Order> list=new ArrayList<>();
		list=orderDao.findAll();

		if(list.size()==0) {
			throw new OrderException("No order found");
		}
		
		return list;
	}

	@Override
	public List<Order> getAllOrderByType(OrderType orderType) throws OrderException {
		List<Order> list=new ArrayList<>();
		list=orderDao.findAll();

		if(list.size()==0) {
			throw new OrderException("No order found");
		}
		
		return list;
	}

	

	@Override
	public Order updateOrder(Order order) throws OrderException {
		//Order o=null;
		Optional<Order> opt=orderDao.findById(order.getO_id());
		
		if(opt.isEmpty()) {
			throw new OrderException("No order found to update");
		}
		
		return orderDao.save(order);
		
		
	}

	@Override
	public Order getOrderByID(Integer id) throws OrderException {
		//Order o=null;
		Optional<Order> opt=orderDao.findById(id);
		
		if(opt.isEmpty()) {
			throw new OrderException("No order found to update");
		}
		return opt.get();
	}

	@Override
	public Order addOrder(Integer customerId) throws OrderException, CustomerException {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomeUserDetails cd=(CustomeUserDetails)principal;
		Customer cm=customerDao.findByMobileNo(cd.getUsername());
		if(cm.getCustomerId()!=customerId) {
			throw new CustomerException("Please enter valid Customer ID");
		}
		
		
		Customer c=null;
		
		Optional<Customer> opt=customerDao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerException("No such Customer found");
		}
		c=opt.get();
		List<Product>pList=c.getCart().getProductMap();
		
		if(pList.isEmpty()) {
			throw new OrderException("Please add products to your cart");
		}
		if(c.getAdd()==null) {
			throw new CustomerException("Please add Address to customer first");
		}
		Double amount=0.0;
		
		for(int i=0;i<pList.size();i++) {
			amount+=pList.get(i).getPrice();
			pList.get(i).setQuantity(pList.get(i).getQuantity()-1);
			productDao.save(pList.get(i));
		}
//		pList.forEach(s->{
//			amount+=s.getPrice();
//			s.setQuantity(s.getQuantity()-1);
//			productDao.save(s);
//		});
		c.getCart().setProductMap(new ArrayList<>());
		c.getCart().setTotalAmount(0.0);
		customerDao.save(c);
		
		Order o=new Order(amount, LocalDate.now(), OrderType.PENDING, pList);
		
		return orderDao.save(o);
		
	}

}
