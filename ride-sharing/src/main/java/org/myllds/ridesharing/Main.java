package org.myllds.ridesharing;

import org.myllds.ridesharing.model.RideDetails;
import org.myllds.ridesharing.model.User;
import org.myllds.ridesharing.model.Vehicle;
import org.myllds.ridesharing.repo.RideDetailsRepo;
import org.myllds.ridesharing.repo.UserDetailsRepo;
import org.myllds.ridesharing.service.RideDetailsService;
import org.myllds.ridesharing.service.StatsService;
import org.myllds.ridesharing.service.UserDetailsService;
import org.myllds.ridesharing.service.impl.RideDetailsServiceImpl;
import org.myllds.ridesharing.service.impl.StatsServiceImpl;
import org.myllds.ridesharing.service.impl.UserDetailsServiceImpl;
import org.myllds.ridesharing.strategy.SelectStrategy;
import org.myllds.ridesharing.strategy.impl.SelectOnShortEndTime;
import org.myllds.ridesharing.strategy.impl.SelectOnShortRideTime;

public class Main {
    public static void main(String[] args) {
        UserDetailsRepo userDetailsRepo = new UserDetailsRepo();
        UserDetailsService userDetailsService = new UserDetailsServiceImpl(userDetailsRepo);
        User user1 = new User("Rohan", "M", 36);
        userDetailsService.addUser(user1);
        Vehicle vehicle1 = new Vehicle("Rohan", "Swift", "KA-01-12345");
        userDetailsService.addVehicle(vehicle1);

        User user2 = new User("Shashank", "M", 29);
        userDetailsService.addUser(user2);
        Vehicle vehicle2 = new Vehicle("Shashank", "Baleno", "TS-05-62395");
        userDetailsService.addVehicle(vehicle2);

        User user3 = new User("Nandini", "F", 29);
        userDetailsService.addUser(user3);

        User user4 = new User("Shipra", "F", 27);
        userDetailsService.addUser(user4);
        Vehicle vehicle3 = new Vehicle("Shipra", "Polo", "KA-05-41491");
        userDetailsService.addVehicle(vehicle3);
        Vehicle vehicle4 = new Vehicle("Shipra", "Scooty", "KA-12-12332");
        userDetailsService.addVehicle(vehicle4);
        User user5 = new User("Gaurav", "M", 29);
        userDetailsService.addUser(user5);

        RideDetailsRepo rideDetailsRepo = new RideDetailsRepo();
        RideDetailsService rideDetailsService = new RideDetailsServiceImpl(rideDetailsRepo);

        RideDetails rideDetails = new RideDetails(vehicle1, user1, "O1", "D1", System.currentTimeMillis(), 3600 * 1000, 3);
        rideDetailsService.offerRide(rideDetails);

        RideDetails rideDetails1 = new RideDetails(vehicle2, user2, "O2", "D2", System.currentTimeMillis() - 10 * 1000, 600 * 1000, 4);
        rideDetailsService.offerRide(rideDetails1);

        RideDetails rideDetails2 = new RideDetails(vehicle3, user4, "O3", "D3", System.currentTimeMillis() - 100 * 1000, 1000 * 1000, 4);
        rideDetailsService.offerRide(rideDetails2);

        RideDetails rideDetails3 = new RideDetails(vehicle4, user4, "O4", "D4", System.currentTimeMillis() - 3600 * 1000, 4200 * 1000, 1);
        rideDetailsService.offerRide(rideDetails3);

        SelectStrategy selectStrategy = new SelectOnShortRideTime(rideDetailsRepo);
        rideDetailsService.selectRide(user5, "O1", "D1", selectStrategy);

        SelectOnShortEndTime selectOnShortEndTime = new SelectOnShortEndTime(rideDetailsRepo);
        rideDetailsService.selectRide(user3, "O3", "D3", selectOnShortEndTime);
        rideDetailsService.selectRide(user3, "O4", "D4", selectStrategy);

        StatsService statsService = new StatsServiceImpl(rideDetailsRepo);
        double fuelSaving = statsService.findFuelSaving(user5);
        System.out.println("Fuel Saving by passenger:" + user5.getName() + " is " + fuelSaving);

        double fuelSavingByUser3 = statsService.findFuelSaving(user3);
        System.out.println("Fuel Saving by passenger:" + user3.getName() + " is " + fuelSavingByUser3);

        int totalRideOffered = statsService.findTotalRideOffered(user1);
        System.out.println("Total rides offered by user:" + user1.getName() + " is " + totalRideOffered);

        int totalRideTaken = statsService.findTotalRideTaken(user5);
        System.out.println("Total rides taken by user:" + user5.getName() + " is " + totalRideTaken);

        int totalRideTakenByUser3 = statsService.findTotalRideTaken(user3);
        System.out.println("Total rides taken by user:" + user3.getName() + " is " + totalRideTakenByUser3);
    }
}