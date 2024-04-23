package com.taskproject.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    public  long orgId;

    @Column(name = "name", nullable = false)
     String name;

    @Column(name = "description")
     String description;

    @Column(name = "location")
     String location;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<employee> employees;
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization(Long orgId, String name, String description, String location, List<employee> employees) {
		super();
		this.orgId = orgId;
		this.name = name;
		this.description = description;
		this.location = location;
		this.employees = employees;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", name=" + name + ", description=" + description + ", location="
				+ location + ", employees=" + employees + "]";
	}

	
    
}
