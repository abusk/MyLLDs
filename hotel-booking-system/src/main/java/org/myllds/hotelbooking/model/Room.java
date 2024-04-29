package org.myllds.hotelbooking.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Room {
    protected String roomNumber;
    protected String type;
    protected  double price;
    protected int capacity;
    protected boolean status;
}
