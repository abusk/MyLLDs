package org.myllds.librarysystem.service;

import org.myllds.librarysystem.Model.Member;
import org.myllds.librarysystem.request.ReservationRequest;

import java.util.List;

public class ReservationService {
    private final RepositoryService repositoryService;

    public ReservationService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void reserve(ReservationRequest request) {
        repositoryService.saveReservation(request);
    }
    public List<Member> getMembersReserveBook(String book) {
        return repositoryService.membersOfReservation(book);
    }

    public void clearReserve(String book) {

    }
}
