package com.linux.huhx.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.linux.huhx.json.deserializer.UserJsonDeserializer;
import com.linux.huhx.json.serializer.UserJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSerialize(using = UserJsonSerializer.class)
@JsonDeserialize(using = UserJsonDeserializer.class)
public class User {

  private String username;
  private String password;
  private Address address;
}
