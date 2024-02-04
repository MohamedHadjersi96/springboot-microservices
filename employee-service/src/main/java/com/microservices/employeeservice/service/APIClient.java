package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 With the old version which is @FeignClient(url = "http://localhost:8080,http://localhost:8082", value = "DEPARTMENT-SERVICE" )
 we need to add all url to all instance which is a bad practice if we have a lot of instance so to resolve this problem
 we use a load balancing with Eureka client ID like this @FeignClient(name="DEPARTMENT-SERVICE")
 and like this we will have a dynamic url configuration.
 Here APIClient will internally use load balancer to call The restApi available instance of microservice
 * */

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

  @GetMapping("api/departments/{department-code}")
  DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
