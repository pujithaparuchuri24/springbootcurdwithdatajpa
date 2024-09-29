package com.pujitha.springboot.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pujitha.springboot.dto.AddressRequestDto;
import com.pujitha.springboot.dto.AddressResponseDto;
import com.pujitha.springboot.dto.EmployeeCompositePrimaryKeyRequestDto;
import com.pujitha.springboot.dto.EmployeeCompositePrimaryKeyResponseDto;
import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.AddressEntity;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.entity.EmployeeEntity;
import com.pujitha.springboot.mapper.EmployeeMapper;
import com.pujitha.springboot.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceClassUnitTest {
	@Mock
	private EmployeeRepository repo;

	@Mock
	private EmployeeMapper mapper;

	@InjectMocks
	private EmployeeService service;

	public static EmployeeRequestDto reqeustcreation() {
		EmployeeRequestDto employee = new EmployeeRequestDto();
		EmployeeCompositePrimaryKeyRequestDto pk = new EmployeeCompositePrimaryKeyRequestDto();
		pk.setEmailName("pujitha");
		pk.setEmailId("pujitha@gmail.com");
		employee.setPk(pk);
		employee.setDesingation("dev");
		employee.setSalary(80000.00f);
		AddressRequestDto address = new AddressRequestDto();
		address.setAddress("rjy");
		address.setAddressLine1("add1");
		address.setAddressLine2("add2");
		address.setState("AP");
		address.setZipCode("533101");
		employee.setAddress(List.of(address));
		return employee;
	}

	public static EmployeeEntity entitycreation() {
		EmployeeEntity employee = new EmployeeEntity();
		EmployeeCompositePrimaryKey pk = new EmployeeCompositePrimaryKey();
		pk.setEmailName("pujitha");
		pk.setEmailId("pujitha@gmail.com");
		employee.setPk(pk);
		employee.setDesingation("dev");
		employee.setSalary(80000.00f);
		AddressEntity address = new AddressEntity();
		address.setId(1);
		address.setAddress("rjy");
		address.setAddressLine1("add1");
		address.setAddressLine2("add2");
		address.setState("AP");
		address.setZipCode("533101");
		employee.setAddress(List.of(address));
		return employee;
	}

	public static EmployeeResponseDto responseCreation() {
		EmployeeResponseDto employee = new EmployeeResponseDto();
		EmployeeCompositePrimaryKeyResponseDto pk = new EmployeeCompositePrimaryKeyResponseDto();
		pk.setEmailName("pujitha");
		pk.setEmailId("pujitha@gmail.com");
		employee.setPk(pk);
		employee.setDesingation("dev");
		employee.setSalary(80000.00f);
		AddressResponseDto address = new AddressResponseDto();
		address.setId(1);
		address.setAddress("rjy");
		address.setAddressLine1("add1");
		address.setAddressLine2("add2");
		address.setState("AP");
		address.setZipCode("533101");
		employee.setAddress(List.of(address));
		return employee;
	}

	@Test
	 void saveTestUser() {
		EmployeeRequestDto request= reqeustcreation();
		EmployeeEntity entity= entitycreation();
		EmployeeResponseDto dto = responseCreation();
		Mockito.when(mapper.employeeRequestToEmployeeEntity(request)).thenReturn(entity);
		Mockito.when(mapper.employeeEntityToEmployeeResponseDto(entity)).thenReturn(dto);
		Mockito.when(repo.save(entity)).thenReturn(entity);
		EmployeeResponseDto response = service.saveEmployeeDto(request);
		Assertions.assertEquals(1, response.getAddress().get(0).getId());
	}

}
