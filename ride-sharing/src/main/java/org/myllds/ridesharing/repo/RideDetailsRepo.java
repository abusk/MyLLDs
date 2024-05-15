package org.myllds.ridesharing.repo;

import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideDetailsRepo {
    private final List<RideDetails> rideDetailsList;

    public RideDetailsRepo() {
        this.rideDetailsList = new ArrayList<>();
    }
    public synchronized void addARideDetails(RideDetails rideDetails) {
        rideDetailsList.add(rideDetails);
    }

    public synchronized void updateRide(RideDetails rideDetails) {
        for(RideDetails ride : rideDetailsList) {
            if (ride.getRideId().equalsIgnoreCase(rideDetails.getRideId())) {
                ride.setAvailableSeats(ride.getAvailableSeats() - 1);
                ride.setPassenger(rideDetails.getPassenger());
            }
        }
    }
    public List<RideDetails> getRideByPassenger(User user) {
       return rideDetailsList.stream().filter(rideDetails -> rideDetails.getPassenger().contains(user)).collect(Collectors.toList());
    }
    public List<RideDetails> getRideByDriver(User user) {
        return rideDetailsList.stream().filter(rideDetails -> rideDetails.getDriver().getName().equalsIgnoreCase(user.getName())).toList();
    }
    public List<RideDetails> getMatchRides(String source, String destination) {
        List<RideDetails> collect = rideDetailsList.stream()
                .filter(rideDetails -> rideDetails.getOrigin().equalsIgnoreCase(source))
                .filter(rideDetails -> rideDetails.getDestination().equalsIgnoreCase(destination))
                .filter(rideDetails -> rideDetails.getAvailableSeats() > 0)
                .collect(Collectors.toList());
        return collect;
    }
}
