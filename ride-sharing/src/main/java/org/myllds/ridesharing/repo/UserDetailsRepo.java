package org.myllds.ridesharing.repo;

import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.model.UserDetails;
import org.myllds.ridesharing.model.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDetailsRepo {
    private final Map<String, UserDetails> userDetailsMap;

    public UserDetailsRepo() {
        this.userDetailsMap = new ConcurrentHashMap<>();
    }

    public void addUser(User user) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUser(user);
        userDetailsMap.put(user.getName(), userDetails);
    }

    public void addVehicle(Vehicle vehicle) {
        UserDetails userDetails = userDetailsMap.get(vehicle.getOwner());
        List<Vehicle> vehicles = userDetails.getVehicle();
        vehicles.add(vehicle);
        userDetails.setVehicle(vehicles);
        userDetailsMap.put(vehicle.getOwner(), userDetails);
    }

    public UserDetails getUserDetails(String userName) {
        return userDetailsMap.get(userName);
    }
}
