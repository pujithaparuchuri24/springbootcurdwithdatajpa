package com.pujitha.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//to change the root element name in response in json format
@JsonRootName(value="EmployeeDetails")
// to ignore the null values and send response in json format
@JsonInclude(JsonInclude.Include.NON_NULL)
//to change the root element name in response in XML format
@JacksonXmlRootElement(localName="EmployeeDetails")
public class EmployeeResponseDto {
	
	// to ignore the below property if value as null
	@JacksonXmlProperty
	private EmployeeCompositePrimaryKeyResponseDto pk= new EmployeeCompositePrimaryKeyResponseDto();
	private Float salary;
	private String desingation;
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	//to change the name in xml response employeeaddress parent tag
	@JacksonXmlElementWrapper(localName="employee address")
	@JacksonXmlProperty(localName="add")
	private List<AddressResponseDto> address;

}
