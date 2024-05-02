package com.ServiceRegister;


import org.springframework.context.annotation.Configuration;


import org.springframework.cloud.openfeign.EnableFeignClients;

@Configuration
@EnableFeignClients
public class FeignClientConfiguration {
    // No need to define a bean for EmployeeFeignClient here
}


