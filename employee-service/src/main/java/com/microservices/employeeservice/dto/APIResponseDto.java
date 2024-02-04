package com.microservices.employeeservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class APIResponseDto {

  private EmployeeDto employeeDto;
  private DepartmentDto departmentDto;
}
