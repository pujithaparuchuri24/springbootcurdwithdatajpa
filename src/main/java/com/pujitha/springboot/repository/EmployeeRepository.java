package com.pujitha.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, EmployeeCompositePrimaryKey> {
	
	@Query(value= "select e from EmployeeEntity e where  e.pk.emailName= ?1")
	public EmployeeEntity searchByName(String name);
	
	public List<EmployeeEntity> findByDesingation(String designation);
	
	
}
