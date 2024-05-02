package com.EurekaServer.Services;

import java.util.List;

import com.EurekaServer.entity.Employee;

public interface employeeService {

	boolean mailExist(String email);

	 public String addEmp(Employee emp);

	public boolean ValidateUser(String email, String password);

	public String getRole(String email);

	public boolean ValidateLogin(String email, String password);

	public Employee getEmployeeByEmail(String email);

	public List<Employee> fetchAllemployeeData();

	public Employee getEmployeeByid(long emp_id);

	public void deleteEmployeeById(long emp_id);

	public Employee updateEmployee(Employee existingEmployee);

}
