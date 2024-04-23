package com.taskproject.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskproject.entity.EmployeeLeave;
import com.taskproject.entity.employee;
import com.taskproject.service.EmployeeLeaveService;
import com.taskproject.service.employeeService;
@Controller
public class EmployeeLeaveController {
	@Autowired
	employeeService empser;
     employee emp;
     EmployeeLeave empl;
	@Autowired
	EmployeeLeaveService Els;
    @GetMapping("/employee/leave/{emp_id}")
	public String employeeleave(@PathVariable long emp_id,Model model) {
		 emp=empser.getEmployeeByid(emp_id);
		 model.addAttribute("emps", emp);
		return "EmployeeLeaveForm";
	}
    @PostMapping("/Elsdata")
    public String submitemployeeleave(@ModelAttribute EmployeeLeave empleave, Model model) {
        Els.addleave(empleave);

        // Fetch employee leave details from database
        EmployeeLeave employeeLeave = Els.getEmployeeLeaveById(empleave.getLeaveId()); // Assuming you have a method like this

        // Calculate leave duration in days
        LocalDate startDate = LocalDate.parse(empleave.getStartDate());
        LocalDate endDate = LocalDate.parse(empleave.getEndDate());
        long leaveDuration = ChronoUnit.DAYS.between(startDate, endDate);

        // Add leave duration to the model
        model.addAttribute("leaveDuration", leaveDuration);
        employeeLeave.setDaysTaken((int) leaveDuration);
        // Pass other necessary data to the employeedetail template
        // For example:
        model.addAttribute("employee", employeeLeave.getEmployee());
        // Add more attributes as needed

        return "employeedetail"; // Return the appropriate template
    }
    @GetMapping("/empleav")
    public String viewEmployeeLeaveTable(Model model) {
    	List<EmployeeLeave> employeeList=Els.fetchAllemployeeLeaveData();
    	model.addAttribute("emp", employeeList);
    	return "listLeave";
    	
    }



    

}
