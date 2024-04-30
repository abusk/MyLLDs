package org.myllds.librarysystem;

import org.myllds.librarysystem.Model.Book;
import org.myllds.librarysystem.Model.Library;
import org.myllds.librarysystem.Model.Member;
import org.myllds.librarysystem.dao.impl.BookHoldingsDaoImpl;
import org.myllds.librarysystem.dao.impl.ReservationDaoImpl;
import org.myllds.librarysystem.factory.SearchStrategyFactory;
import org.myllds.librarysystem.request.BookHoldingRequest;
import org.myllds.librarysystem.request.ReservationRequest;
import org.myllds.librarysystem.request.SearchRequest;
import org.myllds.librarysystem.searchstrategy.SearchStrategy;
import org.myllds.librarysystem.service.BookHoldingService;
import org.myllds.librarysystem.service.NotificationService;
import org.myllds.librarysystem.service.PaymentService;
import org.myllds.librarysystem.service.RepositoryService;
import org.myllds.librarysystem.service.ReservationService;
import org.myllds.librarysystem.service.SearchService;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();

        // The System can scan barcode of book and member id
        library.scanBook("");
        library.scanMember("");

        RepositoryService repositoryService = new RepositoryService(new ReservationDaoImpl(),
                new BookHoldingsDaoImpl());
        PaymentService paymentService = new PaymentService();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setType("author");
        SearchStrategy searchStrategy = SearchStrategyFactory.createSearchStrategy(searchRequest);
        SearchService searchService = new SearchService(searchStrategy);
        //* Member will be able to search book by its title, author, subject category as well by the publication date.
        List<Book> search = searchService.search(searchRequest);

        ReservationService reservationService = new ReservationService(repositoryService);
        ReservationRequest reservationRequest = new ReservationRequest();

        // Member will be able to reserve books if the books are not present.
        reservationService.reserve(reservationRequest);

        BookHoldingService bookHoldingService = new BookHoldingService(paymentService, repositoryService);
        BookHoldingRequest bookHoldingRequest = new BookHoldingRequest();

        // Member will be able to request one or more books (max of 5 including pre holdings)
        bookHoldingService.holdBooks(bookHoldingRequest);

        // The System will be able to check the information like who took a particular book or what are the books checked-out by a specific library member
        Member member = bookHoldingService.memberHoldingTheBook("Book1");
        List<Book> books = bookHoldingService.booksHoldsByMember("member1");

        // The system will be able to collect late fine.
        double fine = bookHoldingService.calculateFine(new Member());
        bookHoldingService.pay(fine);

        List<Member> overDueMembers = bookHoldingService.overDueMembers();
        List<Member> reserveBookMembers = reservationService.getMembersReserveBook("book1");
        NotificationService notificationService = new NotificationService();

        // The System will be able to send notification for overdue or reserved book arrival.
        notificationService.notifyOverDue(overDueMembers, "");
        notificationService.notifyReservation(reserveBookMembers, "");
    }
}
