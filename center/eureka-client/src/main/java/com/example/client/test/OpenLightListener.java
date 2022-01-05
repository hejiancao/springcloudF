package com.example.client.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author created by shaos on 2021/8/30
 */
@Component
public class OpenLightListener implements ApplicationListener<OpenDoorEvent> {

  @Override
  public void onApplicationEvent(OpenDoorEvent openDoorEvent) {
    String source = (String) openDoorEvent.getSource();
    // System.out.println(source);
    System.out.println("打开灯光...");
  }
}
