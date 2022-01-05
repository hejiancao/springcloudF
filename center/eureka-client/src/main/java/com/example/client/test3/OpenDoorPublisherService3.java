package com.example.client.test3;

import com.example.client.test2.OpenDoorEvent2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author created by shaos on 2021/8/30
 */
@Service
public class OpenDoorPublisherService3 {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void openDoor() {
    OpenDoorEvent3 event = new OpenDoorEvent3("dto json ....");
    System.out.println("欢迎主人回家...");
    applicationEventPublisher.publishEvent(event);
  }
}
