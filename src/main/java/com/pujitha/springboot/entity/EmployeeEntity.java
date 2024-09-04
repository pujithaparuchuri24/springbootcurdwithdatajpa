package com.pujitha.springboot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@EntityListeners(AuditingEntityListener.class)
public class EmployeeEntity {
	
	@EmbeddedId
	private EmployeeCompositePrimaryKey pk;
	private Float salary;
	private String desingation;
	
	private LocalDateTime creationDate;
	private LocalDateTime updateDate;
	
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
