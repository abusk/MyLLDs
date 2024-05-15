package org.myllds.ridesharing.service;

import org.myllds.ridesharing.exception.NoAvaibleRidesOnTheRouteException;
import org.myllds.ridesharing.exception.NoAvailableSeatsException;
import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.strategy.SelectStrategy;

public interface RideDetailsService {
    void offerRide(RideDetails rideDetails) throws NoAvailableSeatsException;
    RideDetails selectRide(User user, String origin, String destination, SelectStrategy selectStrategy) throws NoAvaibleRidesOnTheRouteException;
}
