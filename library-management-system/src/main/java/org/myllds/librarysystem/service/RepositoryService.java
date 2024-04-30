package org.myllds.librarysystem.service;

import org.myllds.librarysystem.Model.BookHoldings;
import org.myllds.librarysystem.Model.Member;
import org.myllds.librarysystem.dao.BookHoldingsDao;
import org.myllds.librarysystem.dao.ReservationDao;
import org.myllds.librarysystem.request.ReservationRequest;

import java.util.ArrayList;
import java.util.List;

public class RepositoryService {
    private final ReservationDao reservationDao;
    private final BookHoldingsDao bookHoldingsDao;

    public RepositoryService(ReservationDao reservationDao, BookHoldingsDao bookHoldingsDao) {
        this.reservationDao = reservationDao;
        this.bookHoldingsDao = bookHoldingsDao;
    }

    public void saveReservation(ReservationRequest request) {

    }
    public List<Member> membersOfReservation(String book) {
        return new ArrayList<>();
    }
    public void saveHolding(BookHoldings bookHoldings) {

    }
    public List<Member> membersOfPastDue() {
        return new ArrayList<>();
    }
}
