package com.microservices.departmentservice.service;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.exception.ResourceNotFoundException;
import com.microservices.departmentservice.mapper.DepartmentMapper;
import com.microservices.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements  DepartmentService{
  private DepartmentRepository departmentRepository;

  @Override
  public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

    //  *** using mapStruct library ***
    final Department department = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartment(departmentDto);
    final Department saveDepartment = departmentRepository.save(department);
    return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(saveDepartment);

  }

  @Override
  public DepartmentDto getDepartmentByCode(String departmentCode) {

    final Optional<Department> department = departmentRepository.findByDepartmentCode(departmentCode);
    if(department.isEmpty()){
      throw new  ResourceNotFoundException("Department","code", departmentCode);
    }
    //  *** using mapStruct library ***
    return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department.get());

  }

  @Override
  public List<DepartmentDto> getDepartments() {

    final List<Department> departments = departmentRepository.findAll();
    final List<DepartmentDto> result = new ArrayList<>();
    for(Department department : departments){
      final DepartmentDto departmentDto = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department);
      result.add(departmentDto);
    }
    return result;
  }
}
