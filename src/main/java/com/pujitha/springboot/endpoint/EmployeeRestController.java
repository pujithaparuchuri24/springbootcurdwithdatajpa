package com.pujitha.springboot.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pujitha.springboot.dto.EmployeeRequestDto;
import com.pujitha.springboot.dto.EmployeeResponseDto;
import com.pujitha.springboot.entity.EmployeeCompositePrimaryKey;
import com.pujitha.springboot.service.EmployeeService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "Employee", description  = "Employee Management API's")
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;
	
	// when ever we need to get response in xml format then we need add @JacksonXmlRootElement to response class 
	// need to add produces in http reqeust method and we need to request header with "accept"
	
	// when ever our rest service need to consume the xml body then we need to use consumes and @JacksonXmlRootElement in repsonse class
	//need to send header content-type as application/xml from postman
	
	//@Tag(name="save Employee", description = "saving the employee")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = EmployeeResponseDto.class), mediaType = "application/json") }),
	    @ApiResponse(responseCode = "404", description = "The Tutorial with given Id was not found.", content = { @Content(schema = @Schema()) })
	  })
	@PostMapping(value="/employeesave", consumes = {MediaType.APPLICATION_JSON_VALUE,"application/xml"},
			produces={"application/xml", "application/json"})
	public ResponseEntity<EmployeeResponseDto> save(@RequestBody EmployeeRequestDto dto)
	{
		return new ResponseEntity<>(service.saveEmployeeDto(dto),HttpStatus.CREATED);
	}
	// here in below request I have used both produces type if we don't mentioned accept header in postman then by default 
	// it will json because of order precedence.
	@GetMapping(value="/getallemployees", produces={ "application/json", "application/xml"})
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee()
	{
		return new ResponseEntity<>(service.findAllEmployess(),HttpStatus.OK);
	}
	//it is used to call post, delete,put,patch request for basic authorization
	// when we are calling the above type of request we need send the below generated token
	//X-CSRF-TOKEN as request header when we are making post,put,delete
	@GetMapping("/getcsrf")
	public CsrfToken getCsrfToken(HttpServletRequest request)
	{
		return (CsrfToken)request.getAttribute("_csrf");
		
	}
	
	@GetMapping(value="/getemployeebyname",
			produces={"application/xml", "application/json"})
	public ResponseEntity<EmployeeResponseDto> getEmployeeName(@RequestParam String name)
	{
		System.out.println(name);
		return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
	}
	
	@GetMapping(value="/getemployeebydesignation/{designation}", produces={"application/xml", "application/json"})
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmployeeDesignation(@PathVariable String designation)
	{
		return new ResponseEntity<>(service.findAllEmployeeByDesignation(designation),HttpStatus.OK);
	}
	
	@PostMapping(value= "/getEmployeeusingpk", produces={"application/xml", "application/json"})
	public ResponseEntity<EmployeeResponseDto> getEmployeebyusingPK(@RequestBody EmployeeCompositePrimaryKey pk)
	{
		return new ResponseEntity<>(service.findByCompositePrimaryKey(pk),HttpStatus.OK);
	}
}
