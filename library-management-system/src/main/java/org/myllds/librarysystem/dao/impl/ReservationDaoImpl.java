package org.myllds.librarysystem.dao.impl;

import org.myllds.librarysystem.Model.Reservation;
import org.myllds.librarysystem.dao.ReservationDao;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public List<Reservation> load(String bookTitle) {
        return null;
    }

    @Override
    public List<String> reservationByMember(String member) {
        return null;
    }

    @Override
    public List<String> reservationByBook(String book) {
        return null;
    }
}
