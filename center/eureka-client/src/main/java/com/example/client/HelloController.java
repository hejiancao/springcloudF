package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @Value("${server.port}")
  private String port;

  @GetMapping("/hi")
  public String hello() {
    return "Hello from port:" + port;
  }


}
