package com.linux.huhx.annotation;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<SupportedValues, String> {

  public String message;
  public String[] values;

  @Override
  public void initialize(SupportedValues supportedValues) {
    this.message = supportedValues.message();
    this.values = supportedValues.values();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext arg1) {
    List<String> lstValues = Arrays.asList(values);

    return value != null && !value.isEmpty() && lstValues.contains(value);
  }
}