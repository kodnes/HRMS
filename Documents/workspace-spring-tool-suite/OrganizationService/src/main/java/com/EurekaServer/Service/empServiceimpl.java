package com.EurekaServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EurekaServer.Repository.EmployeeRepository;
import com.EurekaServer.entity.Employee;
@Service
public class empServiceimpl implements empService {
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
	public String addEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		repo.save(emp);
		return "user added";
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
}
