package org.myllds.hotelbooking.service;

import org.myllds.hotelbooking.model.Hotel;
import org.myllds.hotelbooking.searchstrategy.SearchHotel;
import org.myllds.hotelbooking.searchstrategy.SearchRequest;

import java.util.List;

public class SearchService {
    private final SearchHotel searchHotel;
    public SearchService(SearchHotel searchHotel) {
        this.searchHotel = searchHotel;
    }
    public List<Hotel> searchHotels(SearchRequest request) {
        return searchHotel.search(request);
    }
}
