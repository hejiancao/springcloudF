package com.example.client.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author created by shaos on 2021/8/30
 */
@Service
public class OpenDoorPublisherService {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void openDoor() {
    OpenDoorEvent event = new OpenDoorEvent("dto json ....");
    System.out.println("欢迎主人回家...");
    applicationEventPublisher.publishEvent(event);
  }
}
