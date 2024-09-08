package com.pujitha.springboot.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeRequestDto {
	private EmployeeCompositePrimaryKeyRequestDto pk;
	private Float salary;
	private String desingation;
	private List<AddressRequestDto> address;

}
