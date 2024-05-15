package org.myllds.ridesharing.service.impl;

import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.model.Vehicle;
import org.myllds.ridesharing.repo.UserDetailsRepo;
import org.myllds.ridesharing.service.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

   private final UserDetailsRepo userDetailsRepo;

    public UserDetailsServiceImpl(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    @Override
    public void addUser(User user) {
        userDetailsRepo.addUser(user);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        userDetailsRepo.addVehicle(vehicle);
    }
}
