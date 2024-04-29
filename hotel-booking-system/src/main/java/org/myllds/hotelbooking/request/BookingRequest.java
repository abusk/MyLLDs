package org.myllds.hotelbooking.request;

import org.myllds.hotelbooking.model.Customer;
import org.myllds.hotelbooking.model.RoomType;

public class BookingRequest {
    private String hotel;
    private RoomType roomType;
    private double priceRange;
    private Customer customer;
}
