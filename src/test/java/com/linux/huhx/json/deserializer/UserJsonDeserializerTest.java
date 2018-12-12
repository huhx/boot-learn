package com.linux.huhx.json.deserializer;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linux.huhx.data.TestUserDataProvider;
import com.linux.huhx.domain.User;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class UserJsonDeserializerTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void shouldDeserializeUser() throws IOException {
    String jsonString = "{\"username\":\"huhx\",\"password\":\"1234\",\"address\":\"China-Hubei-Wuhan\"}";

    User user = objectMapper.readValue(jsonString, User.class);
    assertEquals(TestUserDataProvider.createUser(), user);
  }
}