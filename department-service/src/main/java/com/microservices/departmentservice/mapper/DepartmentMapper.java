package com.microservices.departmentservice.mapper;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

  DepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(DepartmentMapper.class);

  DepartmentDto mapToDepartmentDto(Department department);
  Department mapToDepartment(DepartmentDto departmentDto);
}
