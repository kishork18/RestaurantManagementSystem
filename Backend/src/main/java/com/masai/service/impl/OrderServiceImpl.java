package com.masai.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.entity.Order;
import com.masai.entity.User;
import com.masai.repository.OrderRepository;
import com.masai.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Order createOrder(Order order) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		order.setUser(user);
		order.setOrderItems(new ArrayList<>());
		order.setOrderDate(LocalDateTime.now());
		return orderRepo.save(order);
	}

	@Override
	public Order deleteOrder(long id) {
		Order order= orderRepo.findById(id).orElseThrow(()->new RuntimeException("No order found"));
		orderRepo.delete(order);
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		
		return orderRepo.findAll();
	}

}
