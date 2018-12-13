package com.linux.huhx.controller;

import com.linux.huhx.model.People;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peoples")
@Slf4j
public class PeopleController {

  @PostMapping()
  public String postPeople(@RequestBody @Valid People people) {
    log.info(people.getName());
    return "success";
  }
}

