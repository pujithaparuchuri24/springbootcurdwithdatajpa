package com.pujitha.springboot.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AddressEntity implements Serializable {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String state;
	private String address;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	
	//providing bi directional mapping if one to many mapping owns the foreign key column
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumns({ @JoinColumn(name = "emp_name", referencedColumnName = "name"),
	 * 
	 * @JoinColumn(name = "emp_mail", referencedColumnName = "email") }) private
	 * EmployeeEntity employee;
	 */

}
