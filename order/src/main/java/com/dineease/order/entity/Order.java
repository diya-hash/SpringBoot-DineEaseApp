package com.dineease.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.dineease.order.dto.FoodItemsDTO;
import com.dineease.order.dto.Restaurant;
import com.dineease.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("order")
public class Order {
	public Order(Integer orderId, List<FoodItemsDTO> foodItemsList, Restaurant restaurant, UserDTO userDTO) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}
	private Integer orderId;
	private List<FoodItemsDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;
}
