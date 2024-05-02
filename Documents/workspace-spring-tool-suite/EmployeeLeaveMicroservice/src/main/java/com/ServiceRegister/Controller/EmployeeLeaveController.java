package com.ServiceRegister.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ServiceRegister.Service.EmployeeLeaveService;
import com.ServiceRegister.entity.EmployeeLeave;


import java.util.List;

@Controller
public class EmployeeLeaveController {
	private int maxLimitDays;
    @Autowired
    private EmployeeLeaveService els; // Autowire the EmployeeLeaveService bean

    @GetMapping("/listLeave")
    public String viewListLeave(Model model) {
        // Call the EmployeeLeaveService method to get all employee leave data
        List<EmployeeLeave> employeeLeaveData = els.fetchAllemployeeLeaveData();
        model.addAttribute("emp", employeeLeaveData); // Add the employee leave data to the model
        model.addAttribute("maxLimitDays", maxLimitDays);
        return "listLeave"; // Return the listLeave template
    }
    @PostMapping("/Elsdata")
    public String submitemployeeleave(@ModelAttribute EmployeeLeave empleave, Model model) {
        // Assuming you have a service method to save the employee leave data
        els.addleave(empleave);

        // Retrieve start date and end date from the submitted form data
       
        return "redirect:http://localhost:8080/validate"; // Return the appropriate template
    }
}
