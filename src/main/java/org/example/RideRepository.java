package org.example;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    private Map<Integer, Rides[]> userRides = new HashMap<>();

    public void addRides(int userId, Rides[] rides) {
        userRides.put(userId, rides);
    }

    public Rides[] getRides(int userId) {
        return userRides.get(userId);
    }
}
