package org.myllds.hotelbooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Manager {
    private String id;
    private String name;
    private String contact;
}
