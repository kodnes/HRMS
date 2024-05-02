package com.ServiceRegister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ServiceRegister.entity.EmployeeLeave;


@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
}