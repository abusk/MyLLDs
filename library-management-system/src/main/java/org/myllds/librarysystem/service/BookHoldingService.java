package org.myllds.librarysystem.service;

import org.myllds.librarysystem.Model.Book;
import org.myllds.librarysystem.Model.BookHoldings;
import org.myllds.librarysystem.Model.Member;
import org.myllds.librarysystem.request.BookHoldingRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookHoldingService {
    private final PaymentService paymentService;
    private final RepositoryService repositoryService;

    public BookHoldingService(PaymentService paymentService, RepositoryService repositoryService) {
        this.paymentService = paymentService;
        this.repositoryService = repositoryService;
    }

    public boolean holdBooks(BookHoldingRequest request) {
        isMemberHoldingMore(request);
        BookHoldings bookHoldings = new BookHoldings();
        repositoryService.saveHolding(bookHoldings);
        return true;
    }

    public void returnBook(Member memeber, List<Book> books) {

    }

    public double calculateFine(Member member) {
        return 0.0;
    }

    public void pay(double amount) {
        paymentService.pay(amount);
    }

    public List<Book> booksHoldsByMember(String member) {
        return new ArrayList<>();
    }

    public Member memberHoldingTheBook(String book) {
        return null;
    }
    public List<Member> overDueMembers() {
        return new ArrayList<>();
    }

    private void isMemberHoldingMore(BookHoldingRequest request) {

    }
}
