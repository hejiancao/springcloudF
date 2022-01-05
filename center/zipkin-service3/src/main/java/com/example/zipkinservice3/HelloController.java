package com.example.zipkinservice3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(){
    return "Hello from 7003";
  }
}
