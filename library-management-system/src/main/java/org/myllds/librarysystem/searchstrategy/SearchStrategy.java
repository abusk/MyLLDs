package org.myllds.librarysystem.searchstrategy;

import org.myllds.librarysystem.Model.Book;
import org.myllds.librarysystem.request.SearchRequest;

import java.util.List;

public interface SearchStrategy {
    public List<Book> searchBook(SearchRequest request);
}
