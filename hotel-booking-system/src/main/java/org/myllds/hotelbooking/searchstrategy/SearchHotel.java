package org.myllds.hotelbooking.searchstrategy;

import org.myllds.hotelbooking.model.Hotel;

import java.util.List;

public interface SearchHotel {
    List<Hotel> search(SearchRequest request);
}
