package org.myllds.hotelbooking.dao;

import org.myllds.hotelbooking.model.Hotel;

import java.util.List;

public interface HotelDao {
    public String save(Hotel hotel);
    public Hotel findHotelById(String id);
    public List<Hotel> findHotelByLocation(String location);
    public List<Hotel> findHotelsByPrice(double prices);
}
