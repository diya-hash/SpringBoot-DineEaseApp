package com.dineease.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineease.order.dto.OrderDTO;
import com.dineease.order.dto.OrderDTOFromFE;
import com.dineease.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
		OrderDTO savedOrderInDB = orderService.saveOrderInDB(orderDetails);
		return new ResponseEntity<>(savedOrderInDB, HttpStatus.CREATED);
	}
}
