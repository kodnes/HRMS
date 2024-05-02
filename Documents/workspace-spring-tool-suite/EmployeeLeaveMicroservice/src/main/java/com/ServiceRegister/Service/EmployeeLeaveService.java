package com.ServiceRegister.Service;

import java.util.List;


import com.ServiceRegister.entity.EmployeeLeave;
public interface EmployeeLeaveService {

	List<EmployeeLeave> fetchAllemployeeLeaveData();

	public void addleave(EmployeeLeave empleave);

}
