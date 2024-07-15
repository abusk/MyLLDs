package org.myllds.resturantbooking.repository;

import org.myllds.resturantbooking.model.Resturant;
import org.myllds.resturantbooking.model.Slot;

import java.util.Date;
import java.util.List;

public interface ResturantRepo {
    void registerResturant(Resturant resturant);
    void removeResturant(String id);
    void updateTimeSlots(String id, Date date, List<Slot> slotList);
}
