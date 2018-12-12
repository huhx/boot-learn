package com.linux.huhx.json.serializer;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linux.huhx.data.TestUserDataProvider;
import com.linux.huhx.domain.Address;
import com.linux.huhx.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class UserJsonSerializerTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void shouldSerializeUserObject() throws JsonProcessingException {
    User user = TestUserDataProvider.createUser();
    String jsonString = objectMapper.writeValueAsString(user);
    assertEquals("{\"username\":\"huhx\",\"address\":\"China-Hubei-Wuhan\"}", jsonString);
  }
}