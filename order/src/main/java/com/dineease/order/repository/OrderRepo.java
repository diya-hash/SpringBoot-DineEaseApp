package com.dineease.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dineease.order.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer>{
}
