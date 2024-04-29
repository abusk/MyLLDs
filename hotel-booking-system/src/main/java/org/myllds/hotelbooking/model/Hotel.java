package org.myllds.hotelbooking.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public abstract class Hotel {
    protected String id;
    protected String name;
    protected String location;
    protected String address;
    protected Manager manager;
    protected HotelType hotelType;
    protected List<Room> roomList;
}
