package com.masai.service;

import java.util.List;

import com.masai.entity.Order;

public interface OrderService {
	public Order createOrder(Order order);

	public Order deleteOrder(long id);

	public List<Order> getAllOrder();
}
