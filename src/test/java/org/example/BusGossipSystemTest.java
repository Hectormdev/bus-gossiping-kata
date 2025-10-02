package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BusGossipSystemTest {


  @Test
  void itIteratesOneStop(){
    var firstDriver = new BusDriver(List.of(1,2,3));
    var secondDriver = new BusDriver(List.of(1,1,2));

    var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver));
    gossipSystem.iterate();
    assertEquals(2,gossipSystem.getNumberOfDriversAtStop(1));;
  }

  @Test
  void itIteratesTwoStops(){
    var firstDriver = new BusDriver(List.of(1,2,3));
    var secondDriver = new BusDriver(List.of(1,1,2));

    var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver));
    gossipSystem.iterate();
    gossipSystem.iterate();

    assertEquals(1, gossipSystem.getNumberOfDriversAtStop(1));
  }

}
