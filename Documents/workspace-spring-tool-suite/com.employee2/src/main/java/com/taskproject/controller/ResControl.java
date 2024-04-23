package com.taskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskproject.entity.employee;
import com.taskproject.repository.EmployeeRepository;

//@RestController
//@CrossOrigin(origins="http://localhost:3000")

//@RequestMapping("api/")

public class ResControl {
	@Autowired
	private EmployeeRepository repo;
	@GetMapping("users")
	public List<employee>getUsers(){
		return repo.findAll();
	}

}
