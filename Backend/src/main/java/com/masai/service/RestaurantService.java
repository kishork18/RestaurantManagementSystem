package com.masai.service;

import com.masai.entity.Restaurant;

public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant deleteRestaurant(long id);
}
