package com.EurekaServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EurekaServer.Service.empService;
import com.EurekaServer.entity.Employee;

import jakarta.servlet.http.HttpSession;
@Controller
public class empController {
	@Autowired
	empService empser;
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
                     return "redirect:localhost:8080/home"; // Redirect to admin home page
                 } else {
                     return "redirect:http://localhost:8080/ind"; // Redirect to employee details page
                 }
             } else {
                 return "redirect:http://localhost:8080/";
             }
         } else { // If employee already exists
             System.out.println("Employee already exists");
             return "redirect:http://localhost:8080/register"; // Assuming you have a "/home" endpoint configured to handle this redirection
         }
     }

}
