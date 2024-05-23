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

import com.masai.entity.Reservation;
import com.masai.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService resServ;
	@PostMapping("/createRes")
	public ResponseEntity<Reservation> createRes(@RequestBody Reservation res){
		Reservation resr=resServ.createReservation(res);
		return new ResponseEntity<Reservation>(resr, HttpStatus.CREATED);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Reservation> delete(@RequestParam long id){
		Reservation res= resServ.deleteReservation(id);
		return new ResponseEntity<Reservation>(res, HttpStatus.ACCEPTED);
	}
}
