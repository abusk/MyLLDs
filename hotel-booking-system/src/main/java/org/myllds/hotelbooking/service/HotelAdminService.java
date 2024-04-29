package org.myllds.hotelbooking.service;

import org.myllds.hotelbooking.dao.HotelDao;
import org.myllds.hotelbooking.dao.RoomDao;
import org.myllds.hotelbooking.model.Hotel;
import org.myllds.hotelbooking.model.Room;

public class HotelAdminService {
    private final HotelDao hotelDao;
    private final RoomDao roomDao;
    public HotelAdminService(HotelDao hotelDao, RoomDao roomDao) {
        this.hotelDao = hotelDao;
        this.roomDao = roomDao;
    }
    public String onboardAHotel(Hotel hotel) {
        hotelDao.save(hotel);
        return "Onboarded";
    }

    private String addRoom(String hotel, Room room) {
        roomDao.save(hotel, room);
        return "added";
    }
    private String updateRoomStatus(String hotel, Room room) {
        return "Ok";
    }
    private String offBoardHotel(Hotel hotel) {
        return "Ok";
    }
}
