# Library Management System
## Question: 
Design a library management system where-
* Any library member should be able to search books by their title, author, subject category as well by the publication date.
* Each book will have a unique identification number and other details including a rack number which will help to physically locate the book.
* There could be more than one copy of a book, and library members should be able to check-out and reserve any copy. We will call each copy of a book, a book item.
* The system should be able to retrieve information like who took a particular book or what are the books checked-out by a specific library member.
* There should be a maximum limit (5) on how many books a member can check-out.
* There should be a maximum limit (10) on how many days a member can keep a book.
* The system should be able to collect fines for books returned after the due date.
* Members should be able to reserve books that are not currently available.
* The system should be able to send notifications whenever the reserved books become available, as well as when the book is not returned within the due date.
* Each book and member card will have a unique barcode. The system will be able to read barcodes from books and members’ library cards.

### Functional Requirements
* Member will be able to search book by its title, author, subject category as well by the publication date. 
* Member will be able to request one or more books (max of 5 including pre holdings)
* Member will be able to reserve books if the books are not present.
* The System will be able to check the information like who took a particular book or what are the books checked-out by a specific library member 
* The System will be able to send notification for overdue or reserved book arrival.
* The system will be able to collect late fine.
* The System can scan barcode of book and member id

### Entities(Needed Classes)
* Member
* Book
* Library
* Manager
* SearchRequest
* SearchService
* SearchStrategy
* SearchStrategyFactory
* BookHoldingService
* BookHoldings
* BookHoldingRequest
* PaymentService
* ReservationService
* Reservation
* ReservationRequest
* NotificationService
* RepositoryService

### Entities-Relationships
```mermaid
classDiagram
class Member {
        id: string,
        barcode: string,
        name: string
}
class Book {
        id: string,
        barcode: string,
        title: string,
        author: string,
        category: string,
        publicationDate: date,
        rackNumber: string
}
class Manager {
        id: string,
        name: string
}
class Library {
        id: string,
        name: string,
        location: string,
        manager: Manger,
        contact: string,
        books: [Book],
        members: [Member],
        maxHoldingDate: int,
        maxNumberOfBook: int,
        fineRate: double,
        scanBook(string)
        scanMember(string)
}
class SearchRequest {
        member: string,
        library: string,
        title: string,
        author: string,
        category: string,
        publicationDate: date
}
class SearchStrategy {
        search(SearchRequest)
}
class SearchByTitle {
    search(SearchRequest)
}
class SearchByAuthor {
    search(SearchRequest)
}
class SearchByCategory {
    search(SearchRequest)
}
class SearchByPublicationDate {
    search(SearchRequest)
}
class SearchService {
        repositoryService: RepositoryService
        searchStrategy: SearchStrategy
        search(seaarchRequest)
}
class SearchStrategyFactory {
        createSearchStrategy(SearchRequest)
}
class BookHoldings {
        id: string,
        member : string,
        book: Book,
        holdingDate: date,
        releaseDate: date,
        expecteddateOfReturn: date,
} 
class BookHoldingRequest {
        member: string,
        book: [Book],
        librabry: string
} 
class Reservation {
        id: string
        member: string,
        booktitle: string
}
class ReservationRequest {
        member: string,
        book: string,
        library: string
} 
class ReservationService {
        repositoryService: RepositoryService
        reserve(ReservationRequest)
} 
class PaymentService {
        pay(amount)
} 
class RepositoryService {
        saveReservation()
        membersOfReservation(library, book)
        saveHolding(BookHoldings)
        membersOfPastdue(date)
}
        
class NotificationService {
        notify()
}
class BookHoldingService {
        paymentService: PaymentService
        repositoryService: RepositoryService
        holdBooks(BookHoldingRequest)
        returnBook(Books)
        calculateLateFine(member)
}
    SearchStrategy <|-- SearchByTitle
    SearchStrategy <|-- SearchByAuthor
    SearchStrategy <|-- SearchByCategory
    SearchStrategy <|-- SearchByPublicationDate
    SearchStrategyFactory -- SearchRequest
    SearchService o-- RepositoryService 
    SearchService -- SearchRequest
    SearchService o-- SearchStrategy
    
    SearchRequest -- Member
        
    Member --* Library
    Library *-- Book
    Manager --* Library
        
    RepositoryService --o ReservationService
    ReservationService -- ReservationRequest
    ReservationService o-- Reservation 
    ReservationRequest -- Member
        
    BookHoldingService o-- RepositoryService
    BookHoldingService o-- PaymentService
    BookHoldingService o-- BookHoldings
    BookHoldingRequest --o BookHoldingService
    Member -- BookHoldingRequest
    Book -- BookHoldingRequest
    
    NotificationService -- Member
    BookHoldingService -- NotificationService
    NotificationService -- ReservationService
```
### Identify Design Pattern from Entities-Relationships
* **Factory Method Pattern:** The instance for different search Strategy are created using factory patter. 
* **Strategy Pattern:** The search for books can be by different type of parameters. We can use Strategy pattern for different search strategy used in Search service.
* **Facade Pattern:** The `BookHoldingService` follows the Facade pattern, where it provides a unified interface to interact with different subsystems or interfaces the system.
* **Singleton Pattern:** All the service class can be Singleton.
* **Repository Pattern:** The `RepositoryService` interacts with storage system which follows repository pattern. 

### Interface-level Coding
[library-management-system/src]()
