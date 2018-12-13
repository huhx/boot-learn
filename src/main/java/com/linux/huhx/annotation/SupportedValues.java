package com.linux.huhx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CustomValidator.class)
public @interface SupportedValues {

  String message() default "Values are not supported";

  String[] values();

  Class<?>[] groups() default {}; //Required by Constraint

  Class<? extends Payload>[] payload() default {}; //Required by Constraint
}