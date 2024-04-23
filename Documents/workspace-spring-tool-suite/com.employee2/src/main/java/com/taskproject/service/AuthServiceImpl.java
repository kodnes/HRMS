package com.taskproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskproject.entity.Auth;
import com.taskproject.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthRepository repo;

	@Override
	public void saveAuth(Auth auth) {
		repo.save(auth);
           		
	}

}
