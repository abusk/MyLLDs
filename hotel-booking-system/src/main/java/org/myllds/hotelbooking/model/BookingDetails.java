package org.myllds.hotelbooking.model;

import java.util.Date;
import java.util.List;

public class BookingDetails {
    private String id;
    private Hotel hotel;
    private List<Room> rooms;
    private Customer customer;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
}
