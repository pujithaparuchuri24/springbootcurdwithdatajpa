package com.pujitha.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.pujitha.springboot.entity.Address;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
	
	private EmployeeCompositePrimaryKey pk;
	private Float salary;
	private String desingation;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	private List<Address> address;

}
