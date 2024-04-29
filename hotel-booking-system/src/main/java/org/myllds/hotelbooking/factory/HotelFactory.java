package org.myllds.hotelbooking.factory;

import org.myllds.hotelbooking.model.Hotel;
import org.myllds.hotelbooking.model.HotelType;
import org.myllds.hotelbooking.model.LuxuryHotel;
import org.myllds.hotelbooking.model.StandardHotel;

public class HotelFactory {
    public Hotel createHotel(HotelType type) {
        switch (type) {
            case LUXURY -> {
                return new LuxuryHotel();
            }
            case STANDARD -> {
                return new StandardHotel();
            }
        }
        return null;
    }
}
