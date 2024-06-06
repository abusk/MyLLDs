# LLD For Flight Booking System 
### Requirements
* user able to register  
* Admin can add new Flight
* Admin can remove Flight
* User can search flights - by source - destination and flight Date
* System shows available flights with available seats
* User select the flights by can be onway or round trip
* user add passengers 
* User select seats on available seats
* User make payment
* System sends notification with tickets to user.
### Entities
* User - Customer, Admin
* Flight
* Seat
* SeatLock
* SeatLockService
* UserService
* FlightService
* FlightRepository
* UserRepository
* SearchService
* SearchRequest
* SearchStrategy - PriceBase, 
* SearchResponse
* Bookings
* BookingService
* BookingRepository
* Passenger
* PaymentService
* Payment
* NotificationService
* Notification
* Ticket
### Entity-Relationships
```mermaid
classDiagram
class User {
        id: String,
        name: String,
        email: String,
        phone: String
}
class Admin {
        adminSecurity: string
}
class Customer {
        
}
class Passenger {
        idProof: String
}
class UserService {
        register()
 }
 class UserRepository {
     addUser()
     findUserById()
 }
 class Seat {
         id: string
         seatLock: SeatLock
 }
 class SeatLock {
         lock: boolean
         expiryTime: timestamp
 }
 class SeatLockService {
         lock()
         unlock()
         isExpiredLock()
 }
 class Flight {
         id: string
         company: string,
         seats: List
         source: string
         destination:
         departureTime:
         arrivalTime:
         status: String
 }
 class FlightService {
         addFlight()
         removeFlight()
         suspendFlight()
         updateFlight()
         updateSeatInfo()
 }
 class FlightRepository {
         addFlight()
         removeFlight()
         updateFlight()
 }
class SearchService {
    search()
}
class SearchStrategy {
    search()
}
class SearchByPriceRange {
    search()
}
class SearchByFlightType {
        search()
}
class FlyingInformation { 
        passenger: Passenger,
        seat: Seat
        lugggegeInfo: String
}
class Bookings {
        id: String
        customer : Customer
        flyingInformation: List
        flight: Flight
        bookingdate: date
        flyingdate: Date
}

class BookingsService {
        bookTickets()
        cancelBooking()
}
class BookingRepository {
        addBooking()
        updateBooking()
        findBookingById()
        findBookingByUser()
}
class PaymentService {
        payment()
}
class Payment {
        amaount : double,
        payementMethod: String
}
class NotificationService {
        sendNotification();
}
class Notification {
        message: String
        tickets: List
}
class Ticket {
        file: File
}
    User <|-- Customer
    User <|-- Admin
    UserService -- User
    UserService --> UserRepository
   
    Flight o-- Seat
    Seat o-- SeatLock
    FlightService --> FlightRepository
    FlightService -- Flight
    
    SearchStrategy <|-- SearchByPriceRange
    SearchStrategy <|-- SearchByFlightType
    SearchService -->  FlightService
    SearchService o-- SearchStrategy
    
    Passenger --o FlyingInformation
    FlyingInformation o-- Seat
    Bookings o-- FlyingInformation
    Bookings o-- Customer
    Bookings o-- Flight
    BookingsService -- Bookings
    BookingsService --> BookingRepository
    PaymentService -- Payment
    BookingsService -- PaymentService
    NotificationService -- Notification
    Notification o-- Ticket
    BookingsService -- NotificationService
    BookingsService -- FlightService 
    BookingsService -- UserService
    SeatLockService -- FlightService 
    
```
### Identify Design Pattern from Entities-Relationships
* Strategy Pattern
* Repository pattern
* Facade Pattern
