package com.example.client;

import com.example.client.test.OpenDoorPublisherService;
import com.example.client.test2.OpenDoorPublisherService2;
import com.example.client.test3.OpenDoorPublisherService3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author created by shaos on 2021/8/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Client {
  @Autowired
  private OpenDoorPublisherService openDoorPublisherService;
  @Autowired
  private OpenDoorPublisherService2 openDoorPublisherService2;
  @Autowired
  private OpenDoorPublisherService3 openDoorPublisherService3;

  @Test
  public void test() {
    // openDoorPublisherService.openDoor();
    // openDoorPublisherService2.openDoor();
    openDoorPublisherService3.openDoor();
  }
}
