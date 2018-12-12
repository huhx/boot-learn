package com.linux.huhx.controller;

import com.linux.huhx.domain.Address;
import com.linux.huhx.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @GetMapping("/")
  public User getUser() {
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

  @PostMapping("/")
  public String postUser(@RequestBody User user) {
    log.info("user info = {}", user);
    return user.toString();
  }
}
