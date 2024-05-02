package com.EurekaServer.Controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EurekaServer.Service.orgService;
import com.EurekaServer.entity.Organization;


@Controller
public class OrgController {
	
	@Autowired
	orgService orgser;
	

	@PostMapping("/orgdata")
    public String submitOrganizationData(@ModelAttribute Organization org,Model model) {
        boolean isNameExists = orgser.checkOrganizationNameExists(org.getName());

        if (isNameExists) {
        	 model.addAttribute("errorMessage", "Organization name already exists!");
            return "orgForm";
        }

        orgser.addOrg(org);
        System.out.println("Organization added");

        return "organizationform"; // Redirect to the organization form page
    
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
        List<String> organizationNames = orgser.fetchAllOrgData()
                .stream()
                .map(Organization::getName) // Assuming Organization has a 'name' field
                .collect(Collectors.toList());
        model.addAttribute("organizationNames", organizationNames);
        return "register";
    }
    @GetMapping("/organization/edit/{orgId}")
    public String showEditForm(@PathVariable long orgId,Model model) {
    	 try {
             Organization org = orgser.getOrganizationByid(orgId); // Assuming empser.getEmployeeById() returns null if employee not found
             if (org != null) {
                 model.addAttribute("organization", org);
                 return "editorganization";
             } else {
                 // Handle the case where employee with given ID is not found
                 return "redirect:/orgdisplay";
             }
         } catch (Exception ex) {
             // Log the exception for debugging purposes
             System.out.println(ex.getMessage());
             // Handle any unexpected exception
             return "redirect:/orgdisplay";
         }
    }
    @PostMapping("/organization/update/{id}")
    public String updateOrganization(@PathVariable long id, @ModelAttribute Organization updatedOrg) {
        try {
            Organization org = orgser.getOrganizationByid(id);
            if (org != null) {
                // Update organization properties with the values from the form
                org.setName(updatedOrg.getName());
                org.setDescription(updatedOrg.getDescription());
                org.setLocation(updatedOrg.getLocation());
                
                // Save the updated organization
                orgser.updateOrg(org);
                
                // Redirect to the organization display page or any other appropriate page
                return "redirect:/orgdisplay";
            } else {
                // Handle the case where organization with given ID is not found
                return "redirect:/orgdisplay";
            }
        } catch (Exception ex) {
            // Log the exception for debugging purposes
            System.out.println(ex.getMessage());
            // Handle any unexpected exception
            return "redirect:/orgdisplay";
        }
    }
    @GetMapping("/organization/delete/{orgId}")
    public String deleteOrganization(@PathVariable long orgId) {
    	 orgser.deleteOrganizationById(orgId);
    	 return "redirect:/orgdisplay";
    	
    }
  
    @GetMapping("/orgdisplay")
	public String viewOrgTable(Model model) {
		List<Organization>orgList=orgser.fetchAllOrgData();
		model.addAttribute("orgs", orgList);
		return "organisationdisplay";
	}
        @GetMapping("/orgform")
        public String orgForm() {
            // Logic to return the organization form template
            return "orgForm";
        }
	


    
    
	
}
