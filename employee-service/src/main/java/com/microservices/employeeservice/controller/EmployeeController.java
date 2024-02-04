package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.dto.APIResponseDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  // build save employee REST API
  @PostMapping
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
    final EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  // build get employee REST API
  @GetMapping("{id}")
  public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
    final APIResponseDto apiResponseDto = employeeService.getEmployee(employeeId);
    return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
  }



}
