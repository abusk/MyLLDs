package org.myllds.ridesharing.service;

import org.myllds.ridesharing.model.User;

public interface StatsService {
    double findFuelSaving(User passenger);
    int findTotalRideTaken(User passenger);
    int findTotalRideOffered(User user);
}
