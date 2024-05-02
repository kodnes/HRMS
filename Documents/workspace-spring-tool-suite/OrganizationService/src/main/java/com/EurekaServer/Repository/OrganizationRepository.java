package com.EurekaServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EurekaServer.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Organization findByName(String name);

}
