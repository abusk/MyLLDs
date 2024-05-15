package org.myllds.ridesharing.strategy.impl;

import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.repo.RideDetailsRepo;
import org.myllds.ridesharing.strategy.SelectStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SelectOnShortRideTime implements SelectStrategy {
    private final RideDetailsRepo rideDetailsRepo;

    public SelectOnShortRideTime(RideDetailsRepo rideDetailsRepo) {
        this.rideDetailsRepo = rideDetailsRepo;
    }

    @Override
    public RideDetails select(String source, String destination) {
        List<RideDetails> matchRides = rideDetailsRepo.getMatchRides(source, destination);
        Optional<RideDetails> minRide = matchRides.stream().min(Comparator.comparingLong(RideDetails::getEndTime));
        if (minRide.isPresent()) {
            return minRide.get();
        } else {
            return null;
        }
    }
}
