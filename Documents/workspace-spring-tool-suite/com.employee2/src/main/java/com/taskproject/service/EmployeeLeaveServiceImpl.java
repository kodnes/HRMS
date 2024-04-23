package com.taskproject.service;

import com.taskproject.entity.EmployeeLeave;
import com.taskproject.repository.EmployeeLeaveRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    @Autowired
    private EmployeeLeaveRepository employeeLeaveRepository;

    @Override
    public EmployeeLeave saveEmployeeLeave(EmployeeLeave employeeLeave) {
        return employeeLeaveRepository.save(employeeLeave);
    }

    @Override
    public void addleave(EmployeeLeave employeeLeave) {
        employeeLeaveRepository.save(employeeLeave);
    }

	@Override
	public List<EmployeeLeave> getLeavesByEmployeeId(Long emp_id) {
		List<EmployeeLeave> leaves = new ArrayList<>();
	    // Return the empty list
	    return leaves;
	}

	@Override
	public EmployeeLeave getEmployeeLeaveById(Long leaveId) {
	    return employeeLeaveRepository.findById(leaveId).orElse(null);
	}

	@Override
	public List<EmployeeLeave> fetchAllemployeeLeaveData() {
		return employeeLeaveRepository.findAll() ;
	}

	
	

}
