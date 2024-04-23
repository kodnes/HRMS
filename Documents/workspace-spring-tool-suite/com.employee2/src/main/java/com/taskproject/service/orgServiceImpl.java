package com.taskproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskproject.entity.Organization;
import com.taskproject.repository.OrganizationRepository;


@Service
public class orgServiceImpl implements orgService{

	@Autowired
	OrganizationRepository orgrepo;
	@Override
	public String addOrg(Organization org) {
		// TODO Auto-generated method stub
		orgrepo.save(org);
		return "organization added";
	}
	@Override
	public List<Organization> fetchAllOrgData() {
		return orgrepo.findAll();
	}
	@Override
	public Organization getOrganizationByid(long orgId) {
		return orgrepo.findById(orgId).get();
	}
	@Override
	public void updateOrg(Organization org) {
            orgrepo.save(org);		
	}
	@Override
	public void deleteOrganizationById(long orgId) {
            orgrepo.deleteById(orgId);		
	}
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
	public List<String> getAllOrganizationNames() {
		 List<Organization> organizations = orgrepo.findAll();

	        // Extract organization names and return as a list of strings
	        return organizations.stream()
	                            .map(Organization::getName)
	                            .collect(Collectors.toList());
	}


}
