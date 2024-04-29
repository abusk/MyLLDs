package org.myllds.hotelbooking.service;

import org.myllds.hotelbooking.request.BookingRequest;

public class HotelBookingService {
    private PaymentService paymentService;
    private RepositoryService repositoryService;
    private ReviewService reviewService;

    public HotelBookingService(RepositoryService repositoryService, PaymentService paymentService, ReviewService reviewService) {
        this.paymentService = paymentService;
        this.repositoryService = repositoryService;
        this.reviewService = reviewService;
    }

    public String bookHotel(BookingRequest bookingRequest) {
        repositoryService.saveBookHotel();
        return "Ok";
    }

    public String cancelBooking(String bookingId) {
        return "Done";
    }

    public String checkOut() {
        pay(0);
        return "Done";
    }
    public String pay(double amount) {
        paymentService.pay();
        return "Ok";
    }
    public String addReviewComments(String hotel, String room, String customer) {
        reviewService.review(hotel, room);
        reviewService.comment(hotel, room);
        return "Ok";
    }

}
