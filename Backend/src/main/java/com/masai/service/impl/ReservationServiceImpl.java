package com.masai.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.entity.Reservation;
import com.masai.entity.Tables;
import com.masai.entity.User;
import com.masai.repository.ReservationRepository;
import com.masai.repository.TablesRepository;
import com.masai.service.ReservationService;
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository resRepo;
	@Autowired
	private TablesRepository tableRepo;

	@Override
	public Reservation createReservation(Reservation res) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		res.setReservationTime(LocalDateTime.now());
		res.setUser(user);
		Tables table = tableRepo.findById(res.getTable().getId())
				.orElseThrow(() -> new RuntimeException("No table found"));
		res.setTable(table);

		return resRepo.save(res);
	}

	@Override
	public Reservation deleteReservation(long id) {
		Reservation res= resRepo.findById(id).orElseThrow(()-> new RuntimeException("No reservation fond"));
		resRepo.delete(res);
		return res;
	}

}
