package com.taskproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class navcontroller {

	@GetMapping("/register")
	public String Registerpage() {
		return "register";
	}
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	@PostMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	@GetMapping("/ind")
	public String indexpage(HttpSession session) {
		session.invalidate();
		return "index";
	}
	@GetMapping("/orgform")
	public String orgForm() {
		return "orgForm";
	}
	@GetMapping("/logout")
	public String index() {
		return "index";
	}
	@GetMapping("/empleavereg")
	public String EmployeeLeaveForm() {
		return "EmployeeLeaveForm";
	}
	@GetMapping("/authform")
	public String AddAuth() {
		return "AddAuth";
	}
	@GetMapping("/employeeform")
	public String employeeform() {
		return "employeeform";
	}
	@GetMapping("/logoutbutton")
	public String logoutbutton(){
		return "index";
	}
	@GetMapping("/logoutt")
	public String logoutpage(){
		return "home";
	}
}
