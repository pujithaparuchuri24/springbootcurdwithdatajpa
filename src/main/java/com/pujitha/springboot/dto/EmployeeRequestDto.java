package com.pujitha.springboot.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JacksonXmlRootElement
public class EmployeeRequestDto {
	private EmployeeCompositePrimaryKeyRequestDto pk;
	private Float salary;
	private String desingation;
	private List<AddressRequestDto> address;

}
