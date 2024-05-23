package com.masai.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer tableNumber;
	private Integer capacity;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	@JsonBackReference
	private Restaurant restaurant;

	@OneToMany(mappedBy = "table", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	private List<Reservation> reservations;

	// getters and setters
}
