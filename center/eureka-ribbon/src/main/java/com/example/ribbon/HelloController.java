package com.example.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

  @GetMapping("/hi")
  @HystrixCommand(fallbackMethod = "hiError")
  public String hello() {
    return restTemplate.getForObject("http://CLIENT/hi", String.class);
  }

  public String hiError() {
    return "Hi error!, Hystrix open!";
  }
}
