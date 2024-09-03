package com.pujitha.springboot.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employeesave")
	public ResponseEntity<EmployeeResponseDto> save(@RequestBody EmployeeRequestDto dto)
	{
		return new ResponseEntity<>(service.saveEmployeeDto(dto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getallemployees")
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee()
	{
		return new ResponseEntity<>(service.findAllEmployess(),HttpStatus.OK);
	}
	
	@GetMapping("/getemployeebyname")
	public ResponseEntity<EmployeeResponseDto> getEmployeeName(@RequestParam String name)
	{
		System.out.println(name);
		return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/getemployeebydesignation/{designation}")
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmployeeDesignation(@PathVariable String designation)
	{
		return new ResponseEntity<>(service.findAllEmployeeByDesignation(designation),HttpStatus.OK);
	}
	
	@PostMapping("/getEmployeeusingpk")
	public ResponseEntity<EmployeeResponseDto> getEmployeebyusingPK(@RequestBody EmployeeCompositePrimaryKey pk)
	{
		return new ResponseEntity<>(service.findByCompositePrimaryKey(pk),HttpStatus.OK);
	}
}
