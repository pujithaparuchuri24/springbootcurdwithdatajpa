package com.pujitha.springboot.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeEntity {
	
	@EmbeddedId
	private EmployeeCompositePrimaryKey pk;
	private Float salary;
	private String desingation;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDate creationDate;
	
	@LastModifiedDate
	@Column(insertable=false)
	private LocalDate updateDate;
	
}
