package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusGossipSystemTest {

    @Test
    void itIteratesTwoStops() {
        var firstDriver = new BusDriver(0, List.of(1, 2, 3));
        var secondDriver = new BusDriver(1, List.of(1, 1, 2));

        var gossipSystem = new BusGossipSystem(List.of(firstDriver, secondDriver));
        gossipSystem.iterate();
        gossipSystem.iterate();

        assertEquals(1, gossipSystem.getNumberOfDriversAtStop(3));
    }

}
