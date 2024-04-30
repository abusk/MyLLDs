package org.myllds.librarysystem.request;

import lombok.Getter;
import lombok.Setter;
import org.myllds.librarysystem.Model.Book;

import java.util.List;

@Setter
@Getter
public class ReservationRequest {
    private String member;
    private String book;
    private String library;
}
