package com.microservices.departmentservice.service;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.mapper.DepartmentMapper;
import com.microservices.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements  DepartmentService{

  private DepartmentRepository departmentRepository;
  private ModelMapper modelMapper;
  @Override
  public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

    //  *** using ModelMapper library ***
    /* final Department department = modelMapper.map(departmentDto, Department.class);
    final Department saveDepartment = departmentRepository.save(department);
    return modelMapper.map(saveDepartment, DepartmentDto.class);*/

    //  *** using mapStruct library ***
    final Department department = DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartment(departmentDto);
    final Department saveDepartment = departmentRepository.save(department);
    return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(saveDepartment);

  }

  @Override
  public DepartmentDto getDepartmentByCode(String departmentCode) {

    final  Department department = departmentRepository.findByDepartmentCode(departmentCode);
    //  *** using ModelMapper library ***
    return modelMapper.map(department, DepartmentDto.class);

    //  *** using mapStruct library ***
    //return DepartmentMapper.DEPARTMENT_MAPPER.mapToDepartmentDto(department);

  }
}
