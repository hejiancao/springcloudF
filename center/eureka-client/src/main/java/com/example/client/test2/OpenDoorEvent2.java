package com.example.client.test2;

import org.springframework.context.ApplicationEvent;

/**
 * 主人回家开门事件
 * @author created by shaos on 2021/8/30
 */
public class OpenDoorEvent2 extends ApplicationEvent {

  public OpenDoorEvent2(Object source) {
    super(source);
  }
}
