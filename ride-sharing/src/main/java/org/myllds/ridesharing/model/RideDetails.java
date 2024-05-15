package org.myllds.ridesharing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RideDetails {
    private String rideId;
    private Vehicle vehicle;

    private User driver;
    private List<User> passenger;
    private String origin;
    private String destination;
    private long startTime;
    private long rideTime;
    private long endTime;
    private int availableSeats;

    public RideDetails(Vehicle vehicle, User driver, String origin, String destination, long startTime, long rideTime, int availableSeats) {
        this.rideId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.startTime = startTime;
        this.rideTime = rideTime;
        this.availableSeats = availableSeats;
        this.passenger = new ArrayList<>();
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public List<User> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<User> passenger) {
        this.passenger = passenger;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getRideTime() {
        return rideTime;
    }

    public void setRideTime(long rideTime) {
        this.rideTime = rideTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
