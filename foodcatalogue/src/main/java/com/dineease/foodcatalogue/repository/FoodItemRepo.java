package com.dineease.foodcatalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dineease.foodcatalogue.entity.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{
}
