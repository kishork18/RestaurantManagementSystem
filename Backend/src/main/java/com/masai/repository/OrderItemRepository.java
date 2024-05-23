package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
