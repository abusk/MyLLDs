# LLD For Hotel Booking System
### Requirements
* Admin will be able to add new hotel
* Admin will be able to add new hotel rooms
* Admin will be able to remove hotel from the system
* Admin will be able to block rooms
* Customer will be able to search for hotels based on location, hotel type, room type and price
* Customer will be able to book available rooms
* Customer can do online Payments on booking.
* Customer will be able to cancel bookings
* Customer will be able to check out
* Customer can see booking history
* Customer can provide review and ratings
### Entities
* Admin
* Hotel
* Room
* HotelAdminService
* Customer
* SearchRequest
* SearchService
* BookingRequest
* BookingDetails
* HotelBookingService
* PaymentService
* ReviewRatingService
### Entity-Relationships
```mermaid
classDiagram
class Admin {
        id: string
        name: string
}
class Manager {
        id: string
        name : string
        contact: string
}
class Hotel {
        id: string
        name: string
        type: string
        address: string
        rooms: List
        manager: Manager
        contactInfo: string
        amenities: strings
        getAvailableRooms(dateRange)
}
class Room {
        roomNumber: string
        type: string
        price: double
        capacity: int
        isAvailable(dateRange)
}
class HotelAdminService {
        addHotel(Hotel)
        addRooms(Rooms)
        blockRoom(Hotel, Room)
        offBoardHotel(Hotel)
}
class Customer {
        id: string
        name: string
        email: string
        mob: string
}
class SearchRequest {
        customer: string
        location: string
        roomType: string
        hotelType: string
        priceRange: double
        dateRange: string
} 
class SearchService { 
        search(SearchRequest)
}
class BookingRequest { 
        hotel: string
        roomType: string
        priceRange: double
        customer: Customer
} 
class BookingDetails {
        id: string
        hotel: Hotel
        rooms: Room
        customer: Customer
        dateRange: string
        totalPrice: double
}
class HotelBookingService {
        paymentService: PaymentService  
        reviewService: ReviewService
        bookingHistory: BookingHistory
        bookHotel(BookingRequest)
        payment()
        cancelBooking(bokkingId)
        checkout(bookingId)
        checkHistory()
} 
class PaymentService {
        pay(amount)
}
class ReviewService {
        rate()
        comment()
}
class  BookingHistory {
        seeHistory()
}

        HotelAdminService <-- Admin
        Hotel o-- Manager
        Hotel o-- Room
        HotelAdminService  <-- Hotel
        SearchRequest o-- Customer
        SearchService <-- SearchRequest
        BookingRequest o-- Customer
        BookingRequest o-- Hotel
        HotelBookingService <-- BookingRequest
        HotelBookingService o-- BookingDetails
        HotelBookingService --> PaymentService
        HotelBookingService --> ReviewService 
        HotelBookingService -->  BookingHistory 

```
### Identify Design Pattern from Entities-Relationships
### DB Schema
### Interface-level Coding