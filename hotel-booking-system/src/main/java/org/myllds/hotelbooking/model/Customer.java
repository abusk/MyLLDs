package org.myllds.hotelbooking.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private String mob;
}
