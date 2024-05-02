package com.EurekaServer.Service;

import java.util.List;

import com.EurekaServer.entity.Organization;

public interface orgService {

	public boolean checkOrganizationNameExists(String name);

	public List<Organization> fetchAllOrgData();

	public Organization getOrganizationByid(long orgId);

	public void updateOrg(Organization org);

	public void deleteOrganizationById(long orgId);

	public String addOrg(Organization org);

	


	

	

}
