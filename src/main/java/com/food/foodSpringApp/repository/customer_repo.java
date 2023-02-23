package com.food.foodSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodSpringApp.dto.customer;

public interface customer_repo extends JpaRepository<customer, Integer> {

}
