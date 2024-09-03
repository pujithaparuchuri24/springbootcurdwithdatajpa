package com.pujitha.springboot.dto;

import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
	
	private EmployeeCompositePrimaryKey pk;
	private Float salary;
	private String desingation;

}
