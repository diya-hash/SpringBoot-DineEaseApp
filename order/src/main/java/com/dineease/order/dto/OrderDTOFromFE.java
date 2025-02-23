package com.dineease.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
	List<FoodItemsDTO> foodItemsList;
	private Integer userId;
	private Restaurant restaurant;
	
	public List<FoodItemsDTO> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItemsDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
