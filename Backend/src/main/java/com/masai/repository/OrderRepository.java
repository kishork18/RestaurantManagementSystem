package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
