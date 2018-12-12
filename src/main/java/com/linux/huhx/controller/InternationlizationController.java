package com.linux.huhx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternationlizationController {

  @GetMapping("/international")
  public String getInternationalPage() {
    return "international";
  }
}
