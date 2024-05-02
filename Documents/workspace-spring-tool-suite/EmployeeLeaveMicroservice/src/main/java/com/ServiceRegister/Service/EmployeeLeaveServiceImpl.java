package com.ServiceRegister.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceRegister.entity.EmployeeLeave;
import com.ServiceRegister.repository.EmployeeLeaveRepository;
@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
     @Autowired
     EmployeeLeaveRepository elr;
	@Override
	public List<EmployeeLeave> fetchAllemployeeLeaveData() {
		return elr.findAll();
	}
	@Override
	public void addleave(EmployeeLeave empleave) {
       elr.save(empleave);
	}

}
