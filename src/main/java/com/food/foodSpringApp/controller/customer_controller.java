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

import com.food.foodSpringApp.dao.customer_dao;
import com.food.foodSpringApp.dto.customer;

@RestController
@RequestMapping("/customers")
public class customer_controller {
	
	@Autowired
	customer_dao customer_dao;
	
	@PostMapping
	public customer savecustomer(@RequestBody customer customer  ) {
		return customer_dao.saveCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public customer getCustomer(@PathVariable int id )
	{
		Optional<customer> oc = customer_dao.getcustomerbyid(id);
		
		if(oc.isEmpty()) {
			return null;
		}
		else {
			return oc.get();
		}	
	}
	
	@GetMapping
	public List<customer> getallcustomer()
	{
		return customer_dao.getallcustomer();
	}
	
	@PutMapping
	public customer updateCustomer(@RequestBody customer customer)
	{
		return customer_dao.updateCustomer(customer);
	}
	
	@DeleteMapping
	public String deletebyid(@RequestParam int id) {
		
		Optional<customer> oc = customer_dao.getcustomerbyid(id);
		if(oc.isPresent()) {
			customer_dao.deletebyid(id);
			return "Customer data is deleted";
		}
		else {
			return "invalid data";
			
		}
	}
	
}
