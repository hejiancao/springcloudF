package com.example.client.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author created by shaos on 2021/8/30
 */
@Service
public class OpenDoorPublisherService2 {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void openDoor() {
    OpenDoorEvent2 event = new OpenDoorEvent2("dto json ....");
    System.out.println("欢迎主人回家...");
    applicationEventPublisher.publishEvent(event);
  }
}
