package com.pujitha.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.entity.EmployeeEntity;
import com.pujitha.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired 
	private EmployeeRepository repo;
	
	public EmployeeResponseDto saveEmployeeDto(EmployeeRequestDto dto)
	{
		EmployeeEntity entity= new EmployeeEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.getPk().setEmailId(dto.getPk().getEmailId());
		entity.getPk().setEmailName(dto.getPk().getEmailName());
		entity= repo.save(entity);
		System.out.println("creationDate from service after save " + entity.getCreationDate());
		EmployeeResponseDto response= new EmployeeResponseDto();
		BeanUtils.copyProperties(entity, response);
		response.getPk().setEmailId(dto.getPk().getEmailId());
		response.getPk().setEmailName(dto.getPk().getEmailName());
		
		return response;
	}
	public List<EmployeeResponseDto> findAllEmployess()
	{
		List<EmployeeEntity> employeeEntity= repo.findAll();
		return employeeEntity.stream().map(e->{
			EmployeeResponseDto response= new EmployeeResponseDto();
			BeanUtils.copyProperties(e, response);
			response.getPk().setEmailId(e.getPk().getEmailId());
			response.getPk().setEmailName(e.getPk().getEmailName());
			return response;
			}).collect(Collectors.toList());
		
	}
	
	public EmployeeResponseDto findByName(String name)
	{
		EmployeeEntity entity= repo.searchByName(name);
		EmployeeResponseDto response= new EmployeeResponseDto();
		BeanUtils.copyProperties(entity, response);
		response.getPk().setEmailId(entity.getPk().getEmailId());
		response.getPk().setEmailName(entity.getPk().getEmailName());
		return response;
		
	}
	
	public List<EmployeeResponseDto> findAllEmployeeByDesignation(String designation)
	{
		List<EmployeeEntity> entity=repo.findByDesingation(designation);
		return entity.stream().map(e->{
			EmployeeResponseDto response= new EmployeeResponseDto();
			BeanUtils.copyProperties(e, response);
			response.getPk().setEmailId(e.getPk().getEmailId());
			response.getPk().setEmailName(e.getPk().getEmailName());
			return response;
			}).collect(Collectors.toList());
	
	}
	
	public EmployeeResponseDto findByCompositePrimaryKey(EmployeeCompositePrimaryKey pk)
	{
		Optional<EmployeeEntity> entity= repo.findById(pk);
		EmployeeResponseDto response= new EmployeeResponseDto();
		if(entity.isPresent())
		{
			EmployeeEntity entity1=entity.get();
			BeanUtils.copyProperties(entity1, response);
			response.getPk().setEmailId(entity1.getPk().getEmailId());
			response.getPk().setEmailName(entity1.getPk().getEmailName());
			return response;
		}
		else
			throw new RuntimeException("record not found");
		
	}

}
