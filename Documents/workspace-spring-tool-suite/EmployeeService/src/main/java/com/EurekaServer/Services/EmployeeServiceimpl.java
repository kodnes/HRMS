package com.EurekaServer.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EurekaServer.Repository.EmployeeRepository;
import com.EurekaServer.entity.Employee;
@Service
public class EmployeeServiceimpl implements employeeService {
	@Autowired
    EmployeeRepository repo;

	@Override
	public boolean mailExist(String email) {
		// TODO Auto-generated method stub
		if(repo.findByEmail(email)== null) {
			return false;
		}else {
			return true;
		}
	
	}

	
	@Override
	public boolean ValidateUser(String email, String password) {
	    // Retrieve employee from database based on email
	    Employee emp = repo.findByEmail(email);

	    // Check if employee exists and if the provided password matches the stored password
	    return emp != null && emp.getPassword().equals(password);
	}

	@Override
	public String getRole(String email) {
	    // Retrieve employee from database based on email
	    Employee emp = repo.findByEmail(email);

	    // Return the role of the employee if found, otherwise return null
	    return emp != null ? emp.getRole() : null;
	}

	@Override
	public boolean ValidateLogin(String email, String password) {
	    
	    Employee emp = repo.findByEmail(email);
	    
	    // Check if employee exists
	    if (emp != null) {
	        // If employee exists, check if the password matches
	        String dbpass = emp.getPassword();
	        if (password.equals(dbpass)) {
	            return true; // Password matches, return true
	        }
	    }
	    return false; // Either email doesn't exist or password doesn't match, return false
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
	    // Call the repository method to search for an employee by email
	    return repo.findByEmail(email);
	}

	@Override
	public List<Employee> fetchAllemployeeData() {
		
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeByid(long emp_id) {
		// TODO Auto-generated method stub
		return repo.findById(emp_id).get();
	}

	@Override
	public void deleteEmployeeById(long emp_id) {
         repo.deleteById(emp_id);	
	}

	


	@Override
	public String addEmp(Employee emp) {
		repo.save(emp);
		return "user added";
	}


	@Override
	public Employee updateEmployee(Employee existingEmployee) {
		return repo.save(existingEmployee);
	}


	

}
