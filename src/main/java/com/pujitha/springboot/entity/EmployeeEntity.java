package com.pujitha.springboot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
public class EmployeeEntity implements Serializable {

	@EmbeddedId
	private EmployeeCompositePrimaryKey pk;
	private Float salary;
	private String desingation;

	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	
	  // unidirection 
	
	  // if we use targetEntity then it will create 3rd table called as employee_entity_address
	  //@OneToMany(targetEntity=Address.class,cascade = CascadeType.ALL)
	 
	  // if we use join column it will create 2 tables called as employeeEntity and Adress table
	  // and address table contains the foreign key
	  //it same for manytoone case also i.e if we add manytoone in address class it will create a foreign key in address table
	
	  @OneToMany(cascade=CascadeType.ALL)
	  @JoinColumns({ @JoinColumn(name = "emp_name", referencedColumnName = "name"),
	  @JoinColumn(name = "emp_mail", referencedColumnName = "email") })
	  private List<AddressEntity> address;
	
	  	//providing bi direction if address class owns foreign key
		//@OneToMany(mappedBy= "employee")
		//private List<Address> address;

	@PrePersist
	protected void onCreate() {
		creationDate = LocalDateTime.now();
		System.out.println("creationDate " + creationDate);
	}

	@PreUpdate
	protected void onUpdate() {

		updateDate = LocalDateTime.now();
		System.out.println("updateDate " + updateDate);
	}
}
