package com.pujitha.springboot.customvalidator;

import java.util.List;

import com.pujitha.springboot.dto.AddressRequestDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ListSizeCheckImpl implements ConstraintValidator<ListSizeCheck, List<AddressRequestDto>> {

	int listminimumsize;

    @Override
    public void initialize(ListSizeCheck constraintAnnotation) {
        this.listminimumsize = constraintAnnotation.listSizeCheck();
    }


	@Override
	public boolean isValid(List<AddressRequestDto> value, ConstraintValidatorContext context) {
		if(value== null )
		{
			return false;
		}
		return value.size()>=1;
		
	}

}
