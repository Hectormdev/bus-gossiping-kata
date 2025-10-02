package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BusGossipTest {

  @Test
  void itSharesGossipAt5Iteration(){
    var firstDriver = new BusDriver(List.of(3,1,2,3));
    var secondDriver = new BusDriver(List.of(3,2,3,1));
    var thirdDriver = new BusDriver(List.of(4,2,3,4,5));
    var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver, thirdDriver));
    int result = gossipSystem.simulate();
    assertEquals(5, result);
  }
}
