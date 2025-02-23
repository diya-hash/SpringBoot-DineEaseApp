package com.dineease.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dineease.order.dto.OrderDTO;
import com.dineease.order.dto.OrderDTOFromFE;
import com.dineease.order.dto.UserDTO;
import com.dineease.order.entity.Order;
import com.dineease.order.mapper.OrderMapper;
import com.dineease.order.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {
		Integer newOrderId = sequenceGenerator.generateNextOrderId();
		UserDTO userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
		Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDto);
		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}
	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://user-service/user/fetchUserById/" + userId, UserDTO.class);
	}
}
