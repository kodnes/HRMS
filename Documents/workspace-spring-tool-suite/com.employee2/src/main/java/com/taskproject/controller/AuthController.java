package com.taskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskproject.entity.Auth;
import com.taskproject.service.AuthService;
import com.taskproject.service.employeeService;
@Controller
public class AuthController {
	 @Autowired
	    private AuthService authService;
	 @Autowired
	 private employeeService empser;
	 @GetMapping("/auth")
	 public String showEmployeeId(Model model) {
		 List<Long>EmployeeIds=empser.getAllEmployeesId();
		 model.addAttribute("employeeIds", EmployeeIds);
		 return "AddAuth";
		 
	 }
	 @PostMapping("/auth/add")
	    public String addAuth(Auth auth) {
	        authService.saveAuth(auth);
	        return "redirect:/home"; // Redirect to the home page after successful submission
	    }
	    

}
