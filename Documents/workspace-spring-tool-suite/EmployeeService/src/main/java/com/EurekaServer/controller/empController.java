package com.EurekaServer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EurekaServer.Services.employeeService;
import com.EurekaServer.entity.Employee;

import jakarta.servlet.http.HttpSession;



@Controller
public class empController {
    
	@Autowired
	employeeService empser;
     Employee emp;
     

     @PostMapping("/reg")
     public String addUserAndValidate(@ModelAttribute Employee emp,
             HttpSession session, Model model) {
         System.out.println(emp.getName());
         boolean empStatus = empser.mailExist(emp.getEmail());
         if (!empStatus) { // If employee does not exist
             empser.addEmp(emp);
             System.out.println("Employee added");

             // Validating user after registration
             String email = emp.getEmail();
             String password = emp.getPassword();
             if (empser.ValidateUser(email, password)) {
                 String role = empser.getRole(email);
                 session.setAttribute("email", email);

                 if (role.equals("admin")) {
                     return "redirect:/home"; // Redirect to admin home page
                 } else {
                     return "index"; // Redirect to employee details page
                 }
             } else {
                 return "login";
             }
         } else { // If employee already exists
             System.out.println("Employee already exists");
             return "index"; // Assuming you have a "/home" endpoint configured to handle this redirection
         }
     }

//
     @PostMapping("/validate")
     public String home(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
         if (empser.ValidateLogin(email, password)) {
             // Assuming ValidateLogin returns the user object with role upon successful login
             Employee emp = empser.getEmployeeByEmail(email); // Method to fetch user details from the database
             session.setAttribute("user", emp); // Storing user details in the session

             if (emp.getRole().equals("admin")) {
                 model.addAttribute("message", "Login successful!");
                 return "home"; // Redirect to home page for admin
             } else if (emp.getRole().equals("employee")) {
                 // Fetch the details of the logged-in employee and add them to the model
                 model.addAttribute("employee", emp);

                 return "employeedetail"; // Redirect to a page to display employee details
             } else {
                 model.addAttribute("message", "Unknown role. Please contact the administrator.");
                 return "index"; // Redirect back to login page
             }
         } else {
             model.addAttribute("message", "Invalid email or password. Please try again.");
             return "index"; // Redirect back to login page
         }
     }


    @GetMapping("/empdisplay")
    public String viewEmployeeTable(Model model) {
    	List<Employee> employeeList=empser.fetchAllemployeeData();
    	model.addAttribute("emp", employeeList);
    	return "employeedisplay";
    	
    }
    
    
    
    @GetMapping(value = "{srNo}")
   public Employee readEmp(@PathVariable String srNo) {
       return emp;
   }
  


    
    @GetMapping("adduser")
    public String addinguser() {
        //TODO: process POST request
        
        return "register";
    }
    @GetMapping("/employee/edit/{emp_id}")
    public String showEditForm(@PathVariable long emp_id, Model model) {
        try {
            Employee emp = empser.getEmployeeByid(emp_id); // Assuming empser.getEmployeeById() returns null if employee not found
            if (emp != null) {
                model.addAttribute("employee", emp);
                return "editEmployee";
            } else {
                // Handle the case where employee with given ID is not found
                return "redirect:/empdisplay";
            }
        } catch (Exception ex) {
            // Log the exception for debugging purposes
            System.out.println(ex.getMessage());
            // Handle any unexpected exception
            return "redirect:/empdisplay";
        }
    }





    @PostMapping("/employee/{emp_id}")
    public String updateEmployee(@PathVariable long emp_id, @ModelAttribute("employee") Employee emp) {
        // Update the employee using the service method
        Employee emp1 = empser.getEmployeeByid(emp_id);
        emp1.setName(emp.getName());
        emp1.setEmail(emp.getEmail());
        emp1.setPhone(emp.getPhone());
        emp1.setDesignation(emp.getDesignation());
        emp1.setLocation(emp.getLocation());
        emp1.setDescription(emp.getDescription());
       
        emp1.setPassword(emp.getPassword());
        
        empser.updateEmployee(emp1);
        return "redirect:/empdisplay"; // Redirect to the employee data page
    } 
    @GetMapping("/employee/{emp_id}")
    public String deleteEmployee(@PathVariable long emp_id) {
    	 empser.deleteEmployeeById(emp_id);
    	 return "redirect:/empdisplay";
    	
    }
    

    @GetMapping("/employee1/edit/{emp_id}")
    public String showEditForm(@PathVariable Long emp_id, Model model) {
        // Retrieve the employee object to edit from the service layer
        Employee emp = empser.getEmployeeByid(emp_id);

        // Check if the employee object exists
        if (emp == null) {
            // Handle the case where the employee is not found
            // You can redirect to an error page or do any appropriate error handling
            return "error";
        }

        // Add the employee object to the model to pre-fill the form
        model.addAttribute("employee", emp);

        // Return the view name for the edit form
        return "editEmployeeForm";
    }
    @PostMapping("/employee1/{emp_id}")
    public String updateemployee(@PathVariable long emp_id, @ModelAttribute("employee") Employee emp) {
        // Retrieve the employee from the database
        Employee existingEmployee = empser.getEmployeeByid(emp_id);
        
        // Check if the employee exists
        if (existingEmployee == null) {
            // Handle the case where the employee is not found
            // You can redirect to an error page or do any appropriate error handling
            return "error"; // Assuming "error" is the name of your error view
        }

        // Update the properties of the existing employee with the values from the form
        existingEmployee.setName(emp.getName());
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setPhone(emp.getPhone());
        existingEmployee.setDesignation(emp.getDesignation());
        existingEmployee.setLocation(emp.getLocation());
        existingEmployee.setDescription(emp.getDescription());
        existingEmployee.setPassword(emp.getPassword());
        
        // Save the updated employee using the service method
        empser.updateEmployee(existingEmployee);
        
        return "employeedetail"; // Redirect to the employee data page
    }
    @GetMapping("/orgform")
    public String redirectToOrgForm() {
        // Redirect to the "orgform" endpoint in the OrganizationService
        return "redirect:http://localhost:8081/orgform";
    }
        
    
    @GetMapping("/employeeform")
    public String yourMethod(Model model) {
        // Assuming you have an Employee object named 'employee'
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeform"; // Assuming your view name is "employeeform.html"
    }

@GetMapping("/empleav")
public String redirectToempleav() {
    return "redirect:http://localhost:8082/empleav";
}
@GetMapping("/auth")
public String redirect() {
	return "redirect:http://localhost:8083/auth";
}
     @GetMapping("/employee/leave/{emp_id}")
     public String leaveForm() {
	   return "redirect:http://localhost:8082/employee/leave/{emp_id}";
}
    

    


    

    



    
    
}

