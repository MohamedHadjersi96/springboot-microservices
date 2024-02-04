package com.microservices.employeeservice.service.impl;

import com.microservices.employeeservice.dto.APIResponseDto;
import com.microservices.employeeservice.dto.DepartmentDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.exception.ResourceNotFoundException;
import com.microservices.employeeservice.mapper.EmployeeMapper;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.service.APIClient;
import com.microservices.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;
  private APIClient apiClient;
  //private WebClient webClient;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    //  *** using mapStruct library ***
    final Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployee(employeeDto);
    final Employee savedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(savedEmployee);
  }

  @Override
  public APIResponseDto getEmployee(Long employeeId) {

     final Employee employee = employeeRepository.findById(employeeId)
             .orElseThrow(
                     ()-> new ResourceNotFoundException("Employee","id", employeeId)
             );

    /**
     *
     *    //call Department API using WebClient
     *    final DepartmentDto departmentDto = webClient.
     *              get()
     *              .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
     *              .retrieve()
     *              .bodyToMono(DepartmentDto.class)
     *              .block();
     */

    //call Department API using Spring Cloud Feign
    final DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

    //  *** using mapStruct library ***
    final EmployeeDto employeeDto = EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(employee);

    return APIResponseDto.builder()
            .employeeDto(employeeDto)
            .departmentDto(departmentDto)
            .build();

  }
}
