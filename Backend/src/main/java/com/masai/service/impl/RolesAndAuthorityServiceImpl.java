package com.masai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.RolesAndAuthority;
import com.masai.repository.RolesAndAuthorityRepository;
import com.masai.service.RolesAndAuthorityService;
@Service
public class RolesAndAuthorityServiceImpl implements RolesAndAuthorityService {
	@Autowired
    private RolesAndAuthorityRepository rar;
	@Override
	public RolesAndAuthority findByName(String name) {
		// TODO Auto-generated method stub
		return rar.findByName(name).orElseThrow(()->new RuntimeException("Role Not Found"));
	}

}
