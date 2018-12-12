package com.linux.huhx.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.linux.huhx.domain.Address;
import com.linux.huhx.domain.User;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserJsonSerializer extends JsonSerializer<User> {

  @Override
  public void serialize(User user, JsonGenerator generator, SerializerProvider provider)
      throws IOException {
    generator.writeStartObject();
    generator.writeStringField("username", user.getUsername());
    generator.writeStringField("address", getStringFromAddress(user.getAddress()));
    generator.writeEndObject();
  }

  private String getStringFromAddress(Address address) {
    return String
        .format("%s-%s-%s", address.getCountry(), address.getProvince(), address.getCity());
  }
}
