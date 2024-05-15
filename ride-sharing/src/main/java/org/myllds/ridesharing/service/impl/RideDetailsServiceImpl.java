package org.myllds.ridesharing.service.impl;

import org.myllds.ridesharing.exception.NoAvaibleRidesOnTheRouteException;
import org.myllds.ridesharing.exception.NoAvailableSeatsException;
import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.repo.RideDetailsRepo;
import org.myllds.ridesharing.service.RideDetailsService;
import org.myllds.ridesharing.strategy.SelectStrategy;

import java.util.List;

public class RideDetailsServiceImpl implements RideDetailsService {

    private final RideDetailsRepo rideDetailsRepo;

    public RideDetailsServiceImpl(RideDetailsRepo rideDetailsRepo) {
        this.rideDetailsRepo = rideDetailsRepo;
    }

    @Override
    public void offerRide(RideDetails rideDetails) throws NoAvailableSeatsException {
        if (rideDetails.getAvailableSeats() <= 0) {
            throw new NoAvailableSeatsException("Available seats can not be less than or equal of zero");
        }
        rideDetailsRepo.addARideDetails(rideDetails);
    }

    @Override
    public RideDetails selectRide(User user, String origin, String destination, SelectStrategy selectStrategy) throws NoAvaibleRidesOnTheRouteException {
        RideDetails selectedRide = selectStrategy.select(origin, destination);
        if(selectedRide == null) {
            throw new NoAvaibleRidesOnTheRouteException("No available rides on the route.");
        }
        List<User> passenger = selectedRide.getPassenger();
        passenger.add(user);
        selectedRide.setPassenger(passenger);
        return selectedRide;
    }
}
