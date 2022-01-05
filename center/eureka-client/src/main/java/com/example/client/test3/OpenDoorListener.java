package com.example.client.test3;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author created by shaos on 2021/8/30
 */
@Service
public class OpenDoorListener {

  @Order(2)
  @EventListener(classes = OpenDoorEvent3.class)
  public void openLight() {
    System.out.println("step2:打开灯光...");
  }

  @Order(3)
  @EventListener(classes = OpenDoorEvent3.class)
  public void openTV() {
    System.out.println("step3:打开电视...");
  }

  @Order(1)
  @EventListener(classes = OpenDoorEvent3.class)
  public void openKT() {
    System.out.println("step1:打开空调...");
  }

}
