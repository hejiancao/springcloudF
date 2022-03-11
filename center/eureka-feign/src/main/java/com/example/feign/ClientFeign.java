package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author created by shaos on 2021/7/12
 */
@FeignClient(value = "CLIENT",fallback = ClientFeign.ClientFeignHystrix.class)
public interface ClientFeign {

  @GetMapping("/hi")
  String hello();

  @GetMapping("getUser")
  String getUser(@RequestParam("id") String id);

  @Component
  class ClientFeignHystrix implements ClientFeign {
    @Override
    public String hello() {
      return "Hi error! Hystrix open!";
    }

    @Override
    public String getUser(String id) {
      return "GetUser error! Hystrix open!";
    }
  }
}
