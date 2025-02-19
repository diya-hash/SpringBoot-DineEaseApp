package com.dineease.restaurantListing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dineease.restaurantListing.dto.RestaurantDTO;
import com.dineease.restaurantListing.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDto);
	RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
