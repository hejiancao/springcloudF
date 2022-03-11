package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author created by shaos on 2021/7/12
 */
@RestController
public class HelloController {

  @Value("${server.port}")
  private String port;

  @GetMapping("/hi")
  public String hello() throws InterruptedException {
    System.out.println("## 请求进来了------>");
    Thread.sleep(3000);
    return "Hello from port:" + port;
  }

  @GetMapping("/getUser")
  public String getUser(@RequestParam("id") String id) throws InterruptedException {
    System.out.println("## 请求进来了------>");
    Thread.sleep(3000);
    return "getUser id = " + id;
  }


}
