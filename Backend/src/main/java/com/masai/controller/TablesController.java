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

import com.masai.entity.Tables;
import com.masai.service.TablesService;

@RestController
@RequestMapping("/tables")
public class TablesController {
	@Autowired
	private TablesService tableserv;
	@PostMapping("/createtable")
	public ResponseEntity<Tables> createTable(@RequestBody Tables table){
		Tables tab= tableserv.createTable(table);
		return new ResponseEntity<Tables>(tab, HttpStatus.CREATED);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Tables> deleteTable(@RequestParam ("id") long id){
		Tables tab= tableserv.deleteTable(id);
		return new ResponseEntity<Tables>(tab, HttpStatus.ACCEPTED);
	}
}
