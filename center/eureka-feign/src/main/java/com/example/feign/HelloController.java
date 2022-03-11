package com.example.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @Resource
  private ClientFeign clientFeign;

  @GetMapping("/hi")
  public String hello() {
    return clientFeign.hello();
  }

  @GetMapping("/getUser")
  public String getUser() {
    return clientFeign.getUser("123");
  }
}
