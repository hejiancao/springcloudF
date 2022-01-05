package com.example.client.test3;

import org.springframework.context.ApplicationEvent;

/**
 * 主人回家开门事件
 * @author created by shaos on 2021/8/30
 */
public class OpenDoorEvent3 extends ApplicationEvent {

  public OpenDoorEvent3(Object source) {
    super(source);
  }
}
