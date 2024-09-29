package com.pujitha.springboot.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pujitha.springboot.dto.AddressRequestDto;
import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.AddressEntity;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.entity.EmployeeEntity;
import com.pujitha.springboot.exception.RecordNotFoundException;
import com.pujitha.springboot.mapper.EmployeeMapper;
import com.pujitha.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired 
	private EmployeeRepository repo;
	
	@Autowired 
	private EmployeeMapper mapper;
	
	public EmployeeResponseDto saveEmployeeDto(EmployeeRequestDto employeeRequestDto)
	{
		
		EmployeeEntity entity= mapper.employeeRequestToEmployeeEntity(employeeRequestDto);
		//EmployeeResponseDto response= mapper.employeeEntityToEmployeeResponseDto(entity);
		// for checking purpose here I'm setting pk realted to null
		//response.setPk(null);
		entity = repo.save(entity);
		return mapper.employeeEntityToEmployeeResponseDto(entity);
	}
	public List<EmployeeResponseDto> findAllEmployess()
	{
		List<EmployeeEntity> employeeEntity= repo.findAll();
		return  mapper.employeeEntityToListEmployeeResposneDto(employeeEntity);
		
	}
	
	public EmployeeResponseDto findByName(String name)
	{
		EmployeeEntity entity= repo.searchByName(name);
		return mapper.employeeEntityToEmployeeResponseDto(entity);
		
	}
	
	public List<EmployeeResponseDto> findAllEmployeeByDesignation(String designation)
	{
		List<EmployeeEntity> entity=repo.findByDesingation(designation);
		return mapper.employeeEntityToListEmployeeResposneDto(entity);
	
	}
	
	public EmployeeResponseDto findByCompositePrimaryKey(EmployeeCompositePrimaryKey pk)
	{
		Optional<EmployeeEntity> entity= repo.findById(pk);
		if(entity.isPresent())
		{
			return mapper.employeeEntityToEmployeeResponseDto(entity.get());
		}
		else
			throw new RecordNotFoundException("record not found");
	}

}
