package com.EurekaServer.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "OrganizationService", url = "http://localhost:8081") // Replace with your Organization Service URL
public interface EmployeeFeignClient {

    @GetMapping("/employeeform") // Define the endpoint to fetch the employee form template
    String getEmployeeFormTemplate(); // Define method to get the employee form template
}
