package org.myllds.hotelbooking;

import org.myllds.hotelbooking.dao.impl.HotelDaoImpl;
import org.myllds.hotelbooking.dao.impl.RoomDaoImpl;
import org.myllds.hotelbooking.model.Customer;
import org.myllds.hotelbooking.model.Hotel;
import org.myllds.hotelbooking.model.LuxuryHotel;
import org.myllds.hotelbooking.model.Room;
import org.myllds.hotelbooking.model.SuiteRoom;
import org.myllds.hotelbooking.request.BookingRequest;
import org.myllds.hotelbooking.searchstrategy.SearchHotel;
import org.myllds.hotelbooking.searchstrategy.SearchHotelByLocation;
import org.myllds.hotelbooking.searchstrategy.SearchRequest;
import org.myllds.hotelbooking.service.HotelAdminService;
import org.myllds.hotelbooking.service.HotelBookingService;
import org.myllds.hotelbooking.service.PaymentService;
import org.myllds.hotelbooking.service.RepositoryService;
import org.myllds.hotelbooking.service.ReviewService;
import org.myllds.hotelbooking.service.SearchService;

import java.util.Arrays;
import java.util.List;

public class HotelBookingSystem {
    public static void main(String[] args) {
        HotelAdminService adminService = new HotelAdminService(new HotelDaoImpl(), new RoomDaoImpl());
        Hotel hotel = new LuxuryHotel();
        Room room = new SuiteRoom();
        Customer customer = new Customer();
        hotel.setRoomList(Arrays.asList(room));
        adminService.onboardAHotel(hotel);
        SearchHotel searchHotel = new SearchHotelByLocation();
        SearchService service = new SearchService(searchHotel);
        List<Hotel> hotels = service.searchHotels(new SearchRequest());
        HotelBookingService bookingService = new HotelBookingService(new RepositoryService(), new PaymentService(), new ReviewService());
        String id = bookingService.bookHotel(new BookingRequest());
        bookingService.checkOut();
        bookingService.addReviewComments(hotel.getId(), room.getRoomNumber(), customer.getId());
        bookingService.cancelBooking(id);
    }
}
