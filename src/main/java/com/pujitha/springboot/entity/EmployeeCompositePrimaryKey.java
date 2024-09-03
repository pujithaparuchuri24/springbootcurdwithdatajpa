package com.pujitha.springboot.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class EmployeeCompositePrimaryKey {
	
	private String emailName;
	private String emailId;

}
