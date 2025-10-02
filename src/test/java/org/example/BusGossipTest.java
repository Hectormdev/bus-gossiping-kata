package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusGossipTest {

    @Test
    void itSharesGossipAt5Iteration() {
        var firstDriver = new BusDriver(List.of(3, 1, 2, 3));
        var secondDriver = new BusDriver(List.of(3, 2, 3, 1));
        var thirdDriver = new BusDriver(List.of(4, 2, 3, 4, 5));
        var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver, thirdDriver));
        int result = gossipSystem.simulate();
        assertEquals(5, result);
    }

    @Test
    void itStopsOnAllSharedSecrets() {
        var firstDriver = new BusDriver(List.of(5, 2, 8));
        var secondDriver = new BusDriver(List.of(5, 2, 8));
        var thirdDriver = new BusDriver(List.of(5, 2, 8));
        var fourthDriver = new BusDriver(List.of(5, 2, 8));
        var fifthDriver = new BusDriver(List.of(5, 2, 8));

        var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver, thirdDriver, fourthDriver, fifthDriver));
        int result = gossipSystem.simulate();
        assertEquals(1, result);
    }
}
