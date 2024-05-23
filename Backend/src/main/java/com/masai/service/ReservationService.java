package com.masai.service;

import com.masai.entity.Reservation;

public interface ReservationService {
	public Reservation createReservation(Reservation res);

	public Reservation deleteReservation(long id);
}
