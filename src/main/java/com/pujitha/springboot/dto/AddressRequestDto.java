package com.pujitha.springboot.dto;

import java.io.Serializable;
import lombok.Data;


@Data
public class AddressRequestDto implements Serializable {

	private String state;
	private String address;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;

}
