package org.myllds.librarysystem.factory;

import org.myllds.librarysystem.request.SearchRequest;
import org.myllds.librarysystem.searchstrategy.SearchByAuthor;
import org.myllds.librarysystem.searchstrategy.SearchByCategory;
import org.myllds.librarysystem.searchstrategy.SearchByPublicationDate;
import org.myllds.librarysystem.searchstrategy.SearchByTitle;
import org.myllds.librarysystem.searchstrategy.SearchStrategy;

public class SearchStrategyFactory {
    public static SearchStrategy createSearchStrategy(SearchRequest request) {
        if(request.getType().equalsIgnoreCase("title")) {
            return new SearchByTitle();
        } else if(request.getType().equalsIgnoreCase("author")) {
            return new SearchByAuthor();
        } else if(request.getType().equalsIgnoreCase("category")) {
            return new SearchByCategory();
        } else if (request.getType().equalsIgnoreCase("publishDate")) {
            return new SearchByPublicationDate();
        }
        return null;
    }
}
