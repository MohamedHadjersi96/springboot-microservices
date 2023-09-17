package com.microservices.employeeservice.mapper;


import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

  EmployeeDto mapToEmployeeDto(Employee employee);
  Employee mapToEmployee(EmployeeDto employeeDto);

}
