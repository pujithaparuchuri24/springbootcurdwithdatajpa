package com.pujitha.springboot.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class EmployeeCompositePrimaryKey implements Serializable  {
	
	@Column(name="Name")
	private String emailName;
	@Column(name="Email")
	private String emailId;

}
