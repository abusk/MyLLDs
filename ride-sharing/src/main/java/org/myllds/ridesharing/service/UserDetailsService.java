package org.myllds.ridesharing.service;

import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.model.Vehicle;

public interface UserDetailsService {
    void addUser(User user);
    void addVehicle(Vehicle vehicle);
}
