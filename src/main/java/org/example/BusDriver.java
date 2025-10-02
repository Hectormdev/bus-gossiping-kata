package org.example;

import java.util.List;

public class BusDriver {
    private final List<Integer> stops;

    public BusDriver(List<Integer> stops) {
        this.stops = stops;
    }

  public boolean isAtStop(int stop) {
    return true;
  }
}
