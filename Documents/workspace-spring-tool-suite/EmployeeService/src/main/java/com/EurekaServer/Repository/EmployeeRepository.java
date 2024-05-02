package com.EurekaServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EurekaServer.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Employee findByEmail(String email);

}
