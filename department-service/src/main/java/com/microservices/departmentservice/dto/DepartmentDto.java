package com.microservices.departmentservice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
  private Long id;
  private String departmentName;
  private String departmentDescription;
  private String departmentCode;
}
