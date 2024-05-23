package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Menu;
import com.masai.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuServ;
	@PostMapping("/addMenu")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu){
		Menu men= menuServ.addMenu(menu);
		return new ResponseEntity<Menu>(men, HttpStatus.ACCEPTED);
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Menu>> findAllMenu(){
		List<Menu> list=menuServ.findAll();
		return new ResponseEntity<List<Menu>>(list, HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Menu> delete(@RequestParam("id") long id){
		Menu menu= menuServ.deleteMenu(id);
		return new ResponseEntity<Menu>(menu, HttpStatus.ACCEPTED);
		
	}
	
}
