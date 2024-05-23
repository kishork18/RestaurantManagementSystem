package com.masai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Menu;
import com.masai.entity.MenuItem;
import com.masai.repository.MenuItemRepository;
import com.masai.repository.MenuRepository;
import com.masai.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepo;
	@Autowired
	private MenuRepository menuRepo;

	@Override
	public MenuItem createMenuItem(MenuItem menuItem) {
		Menu menu = menuRepo.findById(menuItem.getMenu().getId())
				.orElseThrow(() -> new RuntimeException("Menu Not Found"));
		menuItem.setMenu(menu);
		return menuItemRepo.save(menuItem);
	}

	@Override
	public MenuItem deleteMenuItem(Long id) {
		MenuItem menuItem = menuItemRepo.findById(id).orElseThrow(() -> new RuntimeException("No Menu Item Found"));
		menuItemRepo.delete(menuItem);
		return menuItem;
	}

}
