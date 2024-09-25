package com.pujitha.springboot.customvalidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListSizeCheckImpl.class)
public @interface ListSizeCheck {
	int listSizeCheck() default 1;
    String message() default "User must enter single address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};	

}
