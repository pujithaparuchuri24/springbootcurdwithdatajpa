package com.pujitha.springboot.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.EmployeeEntity;

@Mapper(unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface EmployeeMapper {
	
	@Mappings({
	@Mapping(target="address.id", ignore=true),
	@Mapping(target="creationDate", ignore=true),@Mapping(target="updateDate" , ignore=true)})
	public EmployeeEntity employeeRequestToEmployeeEntity(EmployeeRequestDto employeeRequestDto);
	
	public List<EmployeeResponseDto> employeeEntityToListEmployeeResposneDto(List<EmployeeEntity> entity );
	
	public EmployeeResponseDto employeeEntityToEmployeeResponseDto(EmployeeEntity entity);
	

}
