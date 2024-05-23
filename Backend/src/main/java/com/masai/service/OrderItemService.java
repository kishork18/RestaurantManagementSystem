package com.masai.service;

import com.masai.entity.OrderItem;

public interface OrderItemService {
	public OrderItem createOrderItem(OrderItem orderItem);

	public OrderItem deleteordeItem(long id);
}
