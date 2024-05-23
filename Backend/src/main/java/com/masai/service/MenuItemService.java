package com.masai.service;

import com.masai.entity.MenuItem;

public interface MenuItemService {
	public MenuItem createMenuItem(MenuItem menuItem);
	public MenuItem deleteMenuItem(Long id);
}
