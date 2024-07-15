package org.myllds.resturantbooking.repository.impl;

import org.myllds.resturantbooking.model.Resturant;
import org.myllds.resturantbooking.model.Slot;
import org.myllds.resturantbooking.repository.ResturantRepo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResturantRepoImpl implements ResturantRepo {
    private Map<String, Resturant> resturantMap = new ConcurrentHashMap<>();
    private Map<String, Map<Date, List<Slot>>> slotMap = new ConcurrentHashMap<>();
    @Override
    public void registerResturant(Resturant resturant) {

    }

    @Override
    public void removeResturant(String id) {

    }

    @Override
    public void updateTimeSlots(String id, Date date, List<Slot> slotList) {

    }
}
