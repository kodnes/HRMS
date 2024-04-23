package com.taskproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "employee_leave")
public class EmployeeLeave {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long leaveId;

	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private employee Employee;

	    private String startDate;
	    private String endDate;
	    private int daysTaken;
	    private String leaveType;
	    private String status;

	    // Constructors, Getters, and Setters

	    public EmployeeLeave() {
	    }

	    public EmployeeLeave(employee employee, String startDate, String endDate, String leaveType, String status,int daysTaken) {
	        this.Employee = employee;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.leaveType = leaveType;
	        this.status = status;
	        this.daysTaken=daysTaken;
	    }

	    public Long getLeaveId() {
	        return leaveId;
	    }

	    public void setLeaveId(Long leaveId) {
	        this.leaveId = leaveId;
	    }

	    public employee getEmployee() {
	        return Employee;
	    }

	    public void setEmployee(employee employee) {
	        this.Employee = employee;
	    }

	    public String getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(String startDate) {
	        this.startDate = startDate;
	    }

	    public String getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(String endDate) {
	        this.endDate = endDate;
	    }

	    public String getLeaveType() {
	        return leaveType;
	    }

	    public void setLeaveType(String leaveType) {
	        this.leaveType = leaveType;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	    
        
		public int getDaysTaken() {
			return daysTaken;
		}

		public void setDaysTaken(int daysTaken) {
			this.daysTaken = daysTaken;
		}

		@Override
		public String toString() {
			return "EmployeeLeave [leaveId=" + leaveId + ", Employee=" + Employee + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", daysTaken=" + daysTaken + ", leaveType=" + leaveType + ", status="
					+ status + "]";
		}

		

	   
	}


