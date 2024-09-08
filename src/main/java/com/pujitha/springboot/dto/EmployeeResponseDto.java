package com.pujitha.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
	
	private EmployeeCompositePrimaryKeyResponseDto pk= new EmployeeCompositePrimaryKeyResponseDto();
	private Float salary;
	private String desingation;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	private List<AddressResponseDto> address;

}
