package com.pujitha.springboot.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.pujitha.springboot.customvalidator.ListSizeCheck;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement
public class EmployeeRequestDto {
	@NotNull(message="primary key must be pass")
	private EmployeeCompositePrimaryKeyRequestDto pk;
	
	@Min(value= 5000, message= "salary should be grerater than 5000")
	private Float salary;
	
	@NotBlank(message="desingation must not be empty")
	private String desingation;
	
	@ListSizeCheck
	private List<AddressRequestDto> address;

}
