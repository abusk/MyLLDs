# LLD for a Ride Sharing System
### Requirements
* Given in the image [f1.png](f1.png) and [f2.png](f2.png)

### Entities
* User
* Vehicle
* UserDetails
* RideDetails
* UserDetailsRepo
* RideDetailsRepo
* UserDetailsService
* RideDetailService
* StatsService
* SelectStrategy
* SelectStrategyOnRideTime
* SelectStrategyOnEndTime

### Entity-Relationships

```mermaid
classDiagram
class User{
        name: string
        sex: string
        age: int
} 
class Vehicle {
        owner: string
        name: string
        number: string
}
class UserDetails {
        user: User
        vehicle: Vehicle
}
class RideDetails {
        id: string
        origin: string
        destination: string
        startTime: Date
        rideTime: long
        passenger: User
}
class RideDetailsRepo {
        addRideDetails()
        findMatchedRide()
}
class UserDetailsRepo {
        addUserDetails()
}
class SelectStrategy {
        selectRide()
}
class SelectStrategyOnRideTime {
        selectRide()
}
class SelectStrategyOnEndTime {
        selectRide()
} 
class UserDetailsService {
        addUser()
        addVehicle()
}
class RideDetailService {
        offerRide()
        selectRide()
} 
        
class StatsService {
        findFuelSaving()
        findTotalRideTaken()
        findTotalRideOffered()
}
    UserDetails o-- User
    UserDetails o-- Vehicle
    SelectStrategy <|-- SelectStrategyOnRideTime
    SelectStrategy <|-- SelectStrategyOnEndTime 
    UserDetailsService o-- UserDetailsRepo
    UserDetailsRepo --> UserDetails
    UserDetailsService --> UserDetails
    RideDetailsRepo --> RideDetails 
    RideDetailService --> RideDetails 
    RideDetailService --> RideDetailsRepo
    RideDetailService --> SelectStrategy
    RideDetailService o-- UserDetails
    StatsService --> RideDetailsRepo
    StatsService --> RideDetails
    StatsService --> UserDetails 
```