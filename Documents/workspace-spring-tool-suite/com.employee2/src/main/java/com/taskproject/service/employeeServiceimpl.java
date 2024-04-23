package com.taskproject.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskproject.entity.EmployeeLeave;
import com.taskproject.entity.employee;
import com.taskproject.repository.EmployeeLeaveRepository;
import com.taskproject.repository.EmployeeRepository;
@Service
public class employeeServiceimpl implements employeeService {
     @Autowired
     EmployeeRepository repo;
     @Autowired
     private EmployeeLeaveRepository employeeLeaveRepository;
	@Override
	public String UserAdd(employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nameExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ValidateUser(String email, String password) {
	    // Retrieve employee from database based on email
	    employee emp = repo.findByEmail(email);

	    // Check if employee exists and if the provided password matches the stored password
	    return emp != null && emp.getPassword().equals(password);
	}

	@Override
	public String getRole(String email) {
	    // Retrieve employee from database based on email
	    employee emp = repo.findByEmail(email);

	    // Return the role of the employee if found, otherwise return null
	    return emp != null ? emp.getRole() : null;
	}

	@Override
	public employee getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(employee emp) {
		// TODO Auto-generated method stub
		
	}

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
	public String addEmp(employee emp) {
		// TODO Auto-generated method stub
		
		repo.save(emp);
		return "user added";
	}

	@Override
	public boolean ValidateLogin(String email, String password) {
	    
	    employee emp = repo.findByEmail(email);
	    
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
	public void updateEmp(employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmp(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public employee get(String email) {
		return null;
		
		
	}

	@Override
	public employee getEmployeeByEmail(String email) {
	    // Call the repository method to search for an employee by email
	    return repo.findByEmail(email);
	}



	

	@Override
	public Optional<employee> get(long emp_id) {
		// TODO Auto-generated method stub
		return repo.findById(emp_id);
	}

	@Override
	public employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employee getEmployeeByid(long emp_id) {
		// TODO Auto-generated method stub
		return repo.findById(emp_id).get();
	}

	@Override
	public employee updateEmployee(employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
		
	}

	@Override
	public void deleteEmployeeById(long emp_id) {
         repo.deleteById(emp_id);	
	}

	@Override
	public List<Long> getAllEmployeesId() {
		 List<employee> employees = repo.findAll();
	        return employees.stream()
	                       .map(employee::getEmp_id) // Assuming the ID field in Employee is named 'id'
	                       .collect(Collectors.toList());
	    }
	
	@Override
	public List<employee> fetchAllemployeeData() {
		
		return repo.findAll();
	}

	
	
	
	
	
	

}
