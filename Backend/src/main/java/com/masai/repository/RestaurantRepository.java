package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	Optional<Restaurant> findByEmail(String email);
}
