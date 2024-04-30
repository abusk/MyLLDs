package org.myllds.librarysystem.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookHoldings {
    private String id;
    private String member;
    private Book book;
    private Date holdingDate;
    private Date releaseDate;
    private Date expectedDateOfReturn;
}
