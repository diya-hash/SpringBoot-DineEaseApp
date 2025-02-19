package com.dineease.restaurantListing.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineease.restaurantListing.dto.RestaurantDTO;
import com.dineease.restaurantListing.entity.Restaurant;
import com.dineease.restaurantListing.mapper.RestaurantMapper;
import com.dineease.restaurantListing.repository.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	 RestaurantRepo restaurantRepo;
	
	public List<RestaurantDTO> findAllRestaurants(){
		List<Restaurant> restaurantList = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurantList.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOList;
	}
}
