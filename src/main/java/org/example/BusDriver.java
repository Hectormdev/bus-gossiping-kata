package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusDriver {
    private final Integer id;
    private final List<Integer> stops;
    private final HashSet<Integer> secrets;

    private Integer routeIndex = 0;

    public BusDriver(Integer id, List<Integer> stops) {
        this.id = id;
        this.stops = stops;
        this.secrets = new HashSet<>();
        this.secrets.add(id);
    }

    public boolean isAtStop(int stop) {
        return stops.get(routeIndex) == stop;
    }

    public void moveToNextStop() {
        routeIndex = (routeIndex + 1) % stops.size();
    }

    public Integer getNumberOfSecrets() {
        return secrets.size();
    }

    public Integer getCurrentStop() {
        return stops.get(routeIndex);
    }

    public Set<Integer> getSecrets() {
        return secrets;
    }

    public void learnSecrets(Set<Integer> allSecrets) {
        secrets.addAll(allSecrets);
    }
}
