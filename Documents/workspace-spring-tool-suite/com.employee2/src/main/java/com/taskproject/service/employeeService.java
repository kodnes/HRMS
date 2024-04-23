package com.taskproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskproject.entity.employee;
@Service
public interface employeeService {
	public String UserAdd(employee emp);
	public boolean nameExist(String email);
	public boolean ValidateUser(String email,String password);
	public String getRole(String email);
	public employee getUser(String email);
	public void updateUser(employee emp);
	public boolean mailExist(String email);
	public String addEmp(employee emp);
	public boolean ValidateLogin(String email, String password);
	public List<employee> fetchAllemployeeData();
	public employee getEmployeeById(Long id);
	public void updateEmp(employee emp);
	public void deleteEmp(Long id);
	public employee get(String email);
	public employee getEmployeeByEmail(String email);
	public employee getEmployeeByid(long emp_id);
	public employee updateEmployee(employee emp);
	public Optional<employee> get(long emp_id);
	public void deleteEmployeeById(long emp_id);
	public List<Long> getAllEmployeesId();
		
	
		

}
