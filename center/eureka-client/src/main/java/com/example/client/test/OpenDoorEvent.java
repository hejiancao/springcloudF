package com.example.client.test;

import org.springframework.context.ApplicationEvent;

/**
 * 主人回家开门事件
 * @author created by shaos on 2021/8/30
 */
public class OpenDoorEvent extends ApplicationEvent {

  public OpenDoorEvent(Object source) {
    super(source);
  }
}
