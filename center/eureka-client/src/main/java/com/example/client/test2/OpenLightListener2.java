package com.example.client.test2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author created by shaos on 2021/8/30
 */
@Component
public class OpenLightListener2 implements SmartApplicationListener {

  @Override
  public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
    return aClass == OpenDoorEvent2.class;
  }

  @Override
  public boolean supportsSourceType(Class<?> aClass) {
    // 例如 aClass == User.class;
    return true;
  }

  @Override
  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    System.out.println("打开灯光...");
  }

  @Override
  public int getOrder() {
    //数字越小优先级越高
    return 0;
  }
}
