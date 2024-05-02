package com.EurekaServer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EurekaServer.Repository.OrganizationRepository;
import com.EurekaServer.entity.Organization;

@Service
public class orgServiceImpl implements orgService{
	@Autowired
	OrganizationRepository orgrepo;

	@Override
	public boolean checkOrganizationNameExists(String name) {
	    Organization org = orgrepo.findByName(name);
	    if (org != null) {
	        String dbName = org.getName();
	        if (name.equals(dbName)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public List<Organization> fetchAllOrgData() {
		// TODO Auto-generated method stub
		return orgrepo.findAll();
	}

	@Override
	public Organization getOrganizationByid(long orgId) {
		// TODO Auto-generated method stub
		return orgrepo.findById(orgId).get();
	}

	@Override
	public void updateOrg(Organization org) {
      orgrepo.save(org)	;	
	}

	@Override
	public void deleteOrganizationById(long orgId) {
		orgrepo.deleteById(orgId);
	}

	@Override
	public String addOrg(Organization org) {
		// TODO Auto-generated method stub
		orgrepo.save(org);
		return "organization added";
	}

	
	
}
