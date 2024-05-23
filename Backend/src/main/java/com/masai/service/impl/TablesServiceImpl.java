package com.masai.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Restaurant;
import com.masai.entity.Tables;

import com.masai.repository.RestaurantRepository;
import com.masai.repository.TablesRepository;
import com.masai.service.TablesService;
@Service
public class TablesServiceImpl implements TablesService {
	@Autowired
	private TablesRepository tableRepo;
	@Autowired
	private RestaurantRepository restRepo;

	@Override
	public Tables createTable(Tables table) {
		table.setReservations(new ArrayList<>());
		Restaurant rest = restRepo.findById(table.getRestaurant().getId())
				.orElseThrow(() -> new RuntimeException("No Restaurant found"));
		table.setRestaurant(rest);
		return tableRepo.save(table);
	}

	@Override
	public Tables deleteTable(long id) {
		Tables table= tableRepo.findById(id).orElseThrow(()-> new RuntimeException("no table found"));
		tableRepo.deleteById(id);
		return table;
	}

}
