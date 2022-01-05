package com.example.client.test2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author created by shaos on 2021/8/30
 */
@Component
public class OpenKTListener2 implements SmartApplicationListener {

  @Override
  public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
    return aClass == OpenDoorEvent2.class;
  }

  @Override
  public boolean supportsSourceType(Class<?> aClass) {
    return true;
  }

  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    System.out.println("打开空调...");
  }

  @Override
  public int getOrder() {
    return 1;
  }
}
