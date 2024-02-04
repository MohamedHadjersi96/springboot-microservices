package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.APIResponseDto;
import com.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

  EmployeeDto saveEmployee(EmployeeDto employeeDto);
  APIResponseDto getEmployee(Long employeeId);
}
