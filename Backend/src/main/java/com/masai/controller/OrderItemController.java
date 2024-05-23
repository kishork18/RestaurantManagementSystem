package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.OrderItem;
import com.masai.service.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
	@Autowired
	private OrderItemService orderitemserv;
	@PostMapping("/create")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderitem){
		return new ResponseEntity<OrderItem>(orderitemserv.createOrderItem(orderitem), HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<OrderItem> delete(@RequestParam("id") long id){
		return new ResponseEntity<OrderItem>(orderitemserv.deleteordeItem(id), HttpStatus.ACCEPTED);
	}
} 
