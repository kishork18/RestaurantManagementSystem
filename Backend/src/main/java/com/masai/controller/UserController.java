package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.JWTAuthResponse;
import com.masai.dto.LoginDTO;
import com.masai.entity.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;

	@PostMapping("/register")
	public ResponseEntity<User> createUserHandle(@RequestBody User user) {
		User usr = us.addUser(user);
		return new ResponseEntity<User>(usr, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO logindto) {
		String token = us.login(logindto);
		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		return new ResponseEntity<JWTAuthResponse>(jwtAuthResponse, HttpStatus.ACCEPTED);
	}
    @PatchMapping("/update")
	public ResponseEntity<User> updateUserHandle(@RequestBody User user) {
        User usr=us.update(user);
        return new ResponseEntity<User>(usr, HttpStatus.ACCEPTED);
	}
    @GetMapping("/getall")
    public ResponseEntity<List<User>> findAllUser(){
    	List<User> list= us.findAllUser();
    	return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @GetMapping("/getbyemail")
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email){
    	User usr= us.findByEmail(email);
    	return new ResponseEntity<User>(usr, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteByEmail(@RequestParam("email") String email){
    	User usr= us.deletUser(email);
    	return new ResponseEntity<User>(usr, HttpStatus.OK);
    }
}
