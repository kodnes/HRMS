package com.EurekaServer.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class navController {
	@GetMapping("/empleav")
	public String empleav() {
		return "empleav";
	}
	@GetMapping("/orgdisplay")
	public String orgdisplay() {
		return "organisationdisplay";
	}
	
	
	
}
