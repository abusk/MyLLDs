package org.myllds.hotelbooking.dao;

import org.myllds.hotelbooking.model.BookingDetails;

import java.util.List;

public interface BookingsDao {
    public String save(BookingDetails bookingDetails);
    public BookingDetails findById(String id);
    public List<BookingDetails> findByCustomer(String customer);
    public List<BookingDetails> findByRoom(String room);
    public List<BookingDetails> findByHotel(String hotel);
}
