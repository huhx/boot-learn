package com.linux.huhx.model;

import com.linux.huhx.annotation.SupportedValues;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class People {

  @NotNull(message = "name is allowed empty.")
  @SupportedValues(message = "Invalid values found for name", values = {"linux", "huhx", "tomhu"})
  private String name;
}