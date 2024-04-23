package com.taskproject.service;

import java.util.List;

import com.taskproject.entity.EmployeeLeave;
import com.taskproject.entity.employee;

public interface EmployeeLeaveService {
    EmployeeLeave saveEmployeeLeave(EmployeeLeave employeeLeave);

	public void addleave(EmployeeLeave empleave);

	List<EmployeeLeave> getLeavesByEmployeeId(Long emp_id);

	EmployeeLeave getEmployeeLeaveById(Long leaveId);

	List<EmployeeLeave> fetchAllemployeeLeaveData();


	

}
