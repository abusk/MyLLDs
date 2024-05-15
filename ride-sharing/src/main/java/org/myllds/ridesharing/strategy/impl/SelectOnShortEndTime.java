package org.myllds.ridesharing.strategy.impl;

import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.repo.RideDetailsRepo;
import org.myllds.ridesharing.strategy.SelectStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SelectOnShortEndTime implements SelectStrategy {
    private final RideDetailsRepo rideDetailsRepo;

    public SelectOnShortEndTime(RideDetailsRepo rideDetailsRepo) {
        this.rideDetailsRepo = rideDetailsRepo;
    }

    @Override
    public RideDetails select(String source, String destination) {
        List<RideDetails> matchRides = rideDetailsRepo.getMatchRides(source, destination);
        Optional<RideDetails> minRide = matchRides.stream().min(Comparator.comparingLong(RideDetails::getRideTime));
        if(minRide.isPresent()) {
            RideDetails rideDetails = minRide.get();
            rideDetailsRepo.updateRide(rideDetails);
            return rideDetails;
        } else {
            return null;
        }
    }
}
