package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
