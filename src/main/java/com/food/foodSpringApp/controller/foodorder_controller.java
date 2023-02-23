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

import com.food.foodSpringApp.dao.foodorder_dao;
import com.food.foodSpringApp.dto.foodorder;
import com.food.foodSpringApp.dto.item;

@RestController
@RequestMapping("/foodorders")
public class foodorder_controller {

	@Autowired
	foodorder_dao foodorder_dao;
	
	@PostMapping
	public foodorder placefoodorder(@RequestBody foodorder foodorder)
	{
		return foodorder_dao.savefoodorder(foodorder);
	}
	
	
	@GetMapping("/{id}")
	public foodorder getFoodorderbyid(@PathVariable int id)
	{
		Optional<foodorder> of = foodorder_dao.getfoodorderbyid(id);
		
		if (of.isEmpty()) {
			return null;
		}
		else {
			return of.get();
		}
		
	}

	
	@GetMapping
	public List<foodorder> getallFoodorders()
	{
		return foodorder_dao.getallfoodorder();
	}
	
	@PutMapping
	public foodorder updateFoodorder(@RequestBody foodorder foodorder)
	{
		
		return foodorder_dao.updateFoodorder(foodorder);
	}
	
	@DeleteMapping
	public String deletebyid(@RequestParam int id) {
	
		Optional<foodorder> of = foodorder_dao.getfoodorderbyid(id);
		if(of.isPresent()) {
			foodorder_dao.deletebyid(id);
		return "Food order data is deleted";
	}
	else {     
		return "invalid data";
	}
	}
	
//**************************************************************
//additional
//for getting  item data 	
	
	
	@GetMapping("/item/{id}")
	public item getitembyid(@PathVariable int id)
	{
		Optional<item> of = foodorder_dao.getitembyid(id);
		
		if (of.isEmpty()) {
			return null;
		}
		else {
			return of.get();
		}
		
	}
	
	
	
	
	
}
