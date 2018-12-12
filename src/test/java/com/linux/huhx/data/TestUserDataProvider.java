package com.linux.huhx.data;

import com.linux.huhx.domain.Address;
import com.linux.huhx.domain.User;

public class TestUserDataProvider {

  public static User createUser() {
    return User.builder()
        .username("huhx")
        .password("1234")
        .address(Address.builder()
            .country("China")
            .province("Hubei")
            .city("Wuhan")
            .build())
        .build();
  }

}
