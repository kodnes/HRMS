package com.taskproject.repository;


	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.taskproject.entity.employee;

	@Repository
	public interface EmployeeRepository extends JpaRepository<employee, Long> {

		public employee findByEmail(String email);

		public List<employee> searchByEmail(String email);
		
		

		
		
	    
	}



