package com.ServiceRegister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class navController {
	   @GetMapping("/empleav")
         public String empleav() {
        	 return "empleav";
         }
	   @GetMapping("/employee/leave/{emp_id}")
	   public String leaveForm(@PathVariable("emp_id") String empId, Model model) {
	       // Add the emp_id to the model attribute
	       model.addAttribute("empId", empId);
	       return "EmployeeLeaveForm";
	   }

}
