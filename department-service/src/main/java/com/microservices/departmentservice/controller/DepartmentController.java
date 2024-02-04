package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

  private DepartmentService departmentService;

  // build save department REST API
  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
    final DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
  }

  // build get department REST API
  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
    final DepartmentDto department = departmentService.getDepartmentByCode(departmentCode);
    return new ResponseEntity<>(department, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<DepartmentDto>> getDepartments(){
    final List<DepartmentDto> departments = departmentService.getDepartments();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

}
