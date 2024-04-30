package org.myllds.librarysystem.request;

import lombok.Getter;
import lombok.Setter;
import org.myllds.librarysystem.Model.Book;

import java.util.List;

@Setter
@Getter
public class BookHoldingRequest {
    private String member;
    private List<Book> books;
    private String library;
}
