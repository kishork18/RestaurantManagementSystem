package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.RolesAndAuthority;

public interface RolesAndAuthorityRepository extends JpaRepository<RolesAndAuthority, Long> {
	Optional<RolesAndAuthority> findByName(String name);
}
