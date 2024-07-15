package org.myllds.resturantbooking.service;

import org.myllds.resturantbooking.model.Resturant;
import org.myllds.resturantbooking.model.Slot;

import java.sql.Timestamp;
import java.util.List;

public interface ResturantService {
    void registerResturant(Resturant resturant);
    void updateTimeSlots(String resturantId, List<Slot> slots);
}
