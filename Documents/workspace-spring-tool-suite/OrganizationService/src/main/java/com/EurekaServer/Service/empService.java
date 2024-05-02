package com.EurekaServer.Service;

import com.EurekaServer.entity.Employee;

public interface empService {

	public boolean mailExist(String email);

	public String addEmp(Employee emp);

	public boolean ValidateUser(String email, String password);

	public String getRole(String email);

}
