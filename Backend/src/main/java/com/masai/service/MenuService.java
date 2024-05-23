package com.masai.service;

import java.util.List;

import com.masai.entity.Menu;

public interface MenuService {
	public Menu addMenu(Menu menu);

	public Menu deleteMenu(long id);

	public List<Menu> findAll();
}
