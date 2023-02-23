package com.food.foodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.food.foodSpringApp.dao.product_dao;
import com.food.foodSpringApp.dto.product;


@RestController
@RequestMapping("/products")
public class product_controller {

	@Autowired
	product_dao product_dao;
	
	@PostMapping
	public product saveProduct(@RequestBody product product)
	{
		return product_dao.saveProduct(product);
	}
	
	@GetMapping("/{id}")
	public product getprodctbyid(@PathVariable int id)
	{
		Optional<product> op = product_dao.getproductbyid(id);				
		
		if(op.isEmpty()) {
			return null;
		}
		else {
			return op.get();					
		}
	}
	
	@GetMapping
	public List<product> getallproduct()
	{
		return product_dao.getallProducts();
	}
	
	@PutMapping
	public product updateproduct(@RequestBody product product ) {
		return product_dao.updateProduct(product);
		}
	
	@DeleteMapping
	public String deleteproductbyid(@RequestParam int id)
	{
		Optional<product> op = product_dao.getproductbyid(id);
		
		if(op.isPresent()) {
			return "product data is deleted";
		}
		else {
		return "Invalid data";
		}
	}
	
}
