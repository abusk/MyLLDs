package org.myllds.hotelbooking.factory;

import org.myllds.hotelbooking.model.Room;
import org.myllds.hotelbooking.model.RoomType;
import org.myllds.hotelbooking.model.StandardRoom;
import org.myllds.hotelbooking.model.SuiteRoom;

public class RoomFactory {
    public Room createRoom(RoomType type) {
        switch (type) {
            case SUITE -> {
                return new SuiteRoom();
            }
            case STANDARD -> {
                return new StandardRoom();
            }
        }
        return null;
    }
}
