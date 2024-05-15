package org.myllds.ridesharing.service.impl;

import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.repo.RideDetailsRepo;
import org.myllds.ridesharing.service.StatsService;

import java.util.List;

public class StatsServiceImpl implements StatsService {
    private final RideDetailsRepo rideDetailsRepo;

    public StatsServiceImpl(RideDetailsRepo rideDetailsRepo) {
        this.rideDetailsRepo = rideDetailsRepo;
    }

    @Override
    public double findFuelSaving(User passenger) {
        List<RideDetails> rideByPassenger = rideDetailsRepo.getRideByPassenger(passenger);
        long sum = rideByPassenger.stream().map(RideDetails::getRideTime).mapToLong(l -> l).sum();
        return (double) sum / (3600 * 1000);
    }

    @Override
    public int findTotalRideTaken(User passenger) {
        List<RideDetails> rideByPassenger = rideDetailsRepo.getRideByPassenger(passenger);
        return rideByPassenger.size();
    }

    @Override
    public int findTotalRideOffered(User driver) {
        List<RideDetails> rideByDriver = rideDetailsRepo.getRideByDriver(driver);
        return rideByDriver.size();
    }
}
