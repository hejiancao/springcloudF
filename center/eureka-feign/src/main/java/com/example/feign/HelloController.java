package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @Autowired
  private ClientFeign clientFeign;

  @GetMapping("/hi")
  public String hello() {
    return clientFeign.hello();
  }
}
