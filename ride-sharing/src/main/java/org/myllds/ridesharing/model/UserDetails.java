package org.myllds.ridesharing.model;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {
    private User user;
    private List<Vehicle> vehicles;

    public UserDetails() {
        vehicles = new ArrayList<>();
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
