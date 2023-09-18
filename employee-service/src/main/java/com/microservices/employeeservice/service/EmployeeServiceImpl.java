package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.exception.ResourceNotFoundException;
import com.microservices.employeeservice.mapper.EmployeeMapper;
import com.microservices.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Setter
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;
  private ModelMapper modelMapper;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

    //  *** using ModelMapper library ***
   /*final Employee employee = modelMapper.map(employeeDto, Employee.class);
    final Employee savedEmployee = employeeRepository.save(employee);
    return modelMapper.map(savedEmployee, EmployeeDto.class);*/

    //  *** using mapStruct library ***
    final Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployee(employeeDto);
    final Employee savedEmployee = employeeRepository.save(employee);
    return EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(savedEmployee);
  }

  @Override
  public EmployeeDto getEmployee(Long employeeId) {
     final Employee employee = employeeRepository.findById(employeeId)
             .orElseThrow(
                     ()-> new ResourceNotFoundException("Employee","id", employeeId)
             );
    //  *** using ModelMapper library ***
    //return modelMapper.map(employee, EmployeeDto.class);

    //  *** using mapStruct library ***
    return EmployeeMapper.EMPLOYEE_MAPPER.mapToEmployeeDto(employee);



  }
}
