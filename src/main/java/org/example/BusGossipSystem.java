package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        Map<Integer, List<BusDriver>> busDriverByStops = drivers.stream().collect(groupingBy(BusDriver::getCurrentStop));
        busDriverByStops.values().forEach(this::shareSecrets);
        drivers.forEach(BusDriver::moveToNextStop);

    }

    private void shareSecrets(List<BusDriver> drivers) {
        Set<Integer> allSecrets = drivers.stream().flatMap(driver -> driver.getSecrets().stream()).collect(Collectors.toSet());
        drivers.forEach(driver -> driver.learnSecrets(allSecrets));
    }

    public int getNumberOfDriversAtStop(int stop) {
        return drivers.stream().filter(driver -> driver.isAtStop(stop)).toList().size();
    }
}
