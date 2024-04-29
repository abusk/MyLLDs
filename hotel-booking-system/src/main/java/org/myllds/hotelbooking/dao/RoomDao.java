package org.myllds.hotelbooking.dao;

import org.myllds.hotelbooking.model.Room;

import java.util.List;

public interface RoomDao {
    public String save(String hotel, Room room);
    public Room findById(String id);
    public List<Room> findByHotelId(String id);
    public List<Room> findByCapacity(int capacity);
}
