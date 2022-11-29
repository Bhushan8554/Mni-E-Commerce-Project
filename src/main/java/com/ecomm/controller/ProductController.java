package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("user/byid")
	public ResponseEntity<Product> getProductByIdMapping(@RequestParam("products_id")Integer id){
		Product p=productService.getProdectByid(id);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProductMapping(@RequestBody Product id){
		Product p=productService.addProduct(id);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> UpdateProductMapping(@RequestBody Product id){
		Product p=productService.updateProductdetails(id);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@GetMapping("user/All")
	public ResponseEntity<List<Product>> getAllProductMapping(){
		List<Product> p=productService.getAllProducts();
		return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	}
	
	@GetMapping("user/price/asc")
	public ResponseEntity<List<Product>> getAllProductSortedByPriceMapping(){
		List<Product> p=productService.getAllProductsSortByPrice();
		return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	}
	
	@GetMapping("user/rating/asc")
	public ResponseEntity<List<Product>> getAllProductSortedByRatingMapping(){
		List<Product> p=productService.getAllProductsSortByRating();
		return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	}
	
	@GetMapping("user/name")
	public ResponseEntity<List<Product>> getAllProductByNameMapping(@RequestParam("name")String name){
		List<Product> p=productService.getProdectByName(name);
		return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	}
	
	@GetMapping("user/category")
	public ResponseEntity<List<Product>> getAllProductByCategoryMapping(@RequestBody Category category){
		List<Product> p=productService.getproductByCategory(category);
		return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	}
	
	
}
