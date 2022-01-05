package com.example.zipkinservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/hello")
  public String hello(){
    return restTemplate.getForObject("http://localhost:7002/hello", String.class);
  }
}
