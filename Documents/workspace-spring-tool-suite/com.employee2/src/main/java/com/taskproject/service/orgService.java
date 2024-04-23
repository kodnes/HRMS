package com.taskproject.service;

import java.util.List;

import com.taskproject.entity.Organization;

public interface orgService {

	public String addOrg(Organization org);

	public List<Organization> fetchAllOrgData();

	public Organization getOrganizationByid(long orgId);

	public void updateOrg(Organization org);

	public void deleteOrganizationById(long orgId);

	public boolean checkOrganizationNameExists(String name);

	public List<String> getAllOrganizationNames();

	

	

}
