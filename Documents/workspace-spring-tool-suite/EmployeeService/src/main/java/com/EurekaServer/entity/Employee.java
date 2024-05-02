package com.EurekaServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Emp_id;
	String name;
	String email;
	String phone;
	String designation;
	String organization;
	String role;
	String description;
	String location;
	String password;
	public Employee(Long emp_id, String name, String email, String phone, String designation, String organization,
			String role, String description, String location, String password) {
		super();
		Emp_id = emp_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.designation = designation;
		this.organization = organization;
		this.role = role;
		this.description = description;
		this.location = location;
		this.password = password;
	}

	public Employee() {
		super();
		
	}

	public Long getEmp_id() {
		return Emp_id;
	}

	public void setEmp_id(Long emp_id) {
		Emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [Emp_id=" + Emp_id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", designation=" + designation + ", organization=" + organization + ", role=" + role
				+ ", description=" + description + ", location=" + location + ", password=" + password + "]";
	}
	

	
	
	
	
	
	
}
