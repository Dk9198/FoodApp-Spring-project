package com.food.foodSpringApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double cost;
	private int qunatity;
	private String name;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private foodorder foodorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public foodorder getFoodorder() {
		return foodorder;
	}

	public void setFoodorder(foodorder foodorder) {
		this.foodorder = foodorder;
	}
	
}
