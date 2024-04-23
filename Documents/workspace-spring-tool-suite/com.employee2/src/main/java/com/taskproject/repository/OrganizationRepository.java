package com.taskproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskproject.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	public Organization findByName(String name);
	

}
