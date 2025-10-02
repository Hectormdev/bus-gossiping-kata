package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BusDriverTest {

    @Test
    void itStartsOnRoute() {
        var driver = new BusDriver(0, List.of(3, 1, 2, 3));

        boolean atStop = driver.isAtStop(1);

        assertThat(atStop).isFalse();
    }

    @Test
    void itLoopsBackToStartOfRoute() {
        List<Integer> stops = List.of(3, 1, 2);
        var driver = new BusDriver(0, stops);

        driver.moveToNextStop();
        driver.moveToNextStop();
        driver.moveToNextStop();

        boolean atStop = driver.isAtStop(3);
        assertThat(atStop).isTrue();
    }
}
