package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author created by shaos on 2021/7/12
 */
@FeignClient(value = "CLIENT",fallback = ClientFeign.ClientFeignHystrix.class)
public interface ClientFeign {

  @GetMapping("/hi")
  String hello();

  @Component
  class ClientFeignHystrix implements ClientFeign {
    @Override
    public String hello() {
      return "Hi error! Hystrix open!";
    }
  }
}
