package org.example;

import java.util.List;

public class BusGossipSystem {
    public static final int MAX_STOPS_PER_DAY = 480;
    private final List<BusDriver> drivers;

    public BusGossipSystem(List<BusDriver> drivers) {
        this.drivers = drivers;
    }

    public int simulate() {
        Integer iteration = 0;
        do {
            iterate();
            iteration = iteration + 1;
        } while (!allSecretsShare() && iteration < MAX_STOPS_PER_DAY);
        return iteration;
    }

    private boolean allSecretsShare() {
        return drivers.stream().allMatch(driver -> driver.getNumberOfSecrets() == getAllSecretsNumber());
    }

    private int getAllSecretsNumber() {
        return drivers.size();
    }

    public void iterate() {
        drivers.forEach(BusDriver::moveToNextStop);
    }

    public int getNumberOfDriversAtStop(int stop) {
        return drivers.stream().filter(driver -> driver.isAtStop(stop)).toList().size();
    }
}
