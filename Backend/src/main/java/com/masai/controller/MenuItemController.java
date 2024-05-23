package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.entity.MenuItem;
import com.masai.service.MenuItemService;

public class MenuItemController {
	@Autowired
	private MenuItemService menuItemserv;
    @PostMapping("/createmenuitem")
	public ResponseEntity<MenuItem> createMenuitem(@RequestBody MenuItem menuItem) {
       MenuItem menu= menuItemserv.createMenuItem(menuItem);
       return new ResponseEntity<MenuItem>(menu, HttpStatus.OK);
	}
    public ResponseEntity<MenuItem> delete(@RequestParam long id){
    	MenuItem menu= menuItemserv.deleteMenuItem(id);
    	return new ResponseEntity<MenuItem>(menu, HttpStatus.ACCEPTED);
    }
}
