package com.pujitha.springboot.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
public class EmployeeCompositePrimaryKeyResponseDto implements Serializable  {
	
	private String emailName;
	private String emailId;

}
