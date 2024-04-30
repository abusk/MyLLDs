package org.myllds.librarysystem.dao;

import org.myllds.librarysystem.Model.Reservation;

import java.util.List;

public interface ReservationDao {
    public void save(Reservation reservation);
    public List<Reservation> load(String bookTitle);
    public List<String> reservationByMember(String member);
    public List<String> reservationByBook(String book);
}
