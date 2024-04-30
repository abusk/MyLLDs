package org.myllds.librarysystem.service;

import org.myllds.librarysystem.Model.Book;
import org.myllds.librarysystem.request.SearchRequest;
import org.myllds.librarysystem.searchstrategy.SearchStrategy;

import java.util.List;

public class SearchService {
    private final SearchStrategy searchStrategy;
    public SearchService(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public List<Book> search(SearchRequest request) {
        return searchStrategy.searchBook(request);
    }
}
