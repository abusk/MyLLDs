package org.myllds.librarysystem.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Library {
    private String id;
    private String name;
    private String location;
    private Manager manager;
    private String contact;
    private List<Book> books;
    private List<Member> members;
    private int maxHoldingDate;
    private int maxNumberOfBook;
    private double fineRate;

    public boolean scanBook(String barcode) {
        return true;
    }

    public boolean scanMember(String barcode) {
        return true;
    }

    public void addBook(Book book) {
    }
    public void addMember(Member member) {
    }
}
