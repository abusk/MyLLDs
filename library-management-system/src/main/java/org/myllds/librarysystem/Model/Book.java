package org.myllds.librarysystem.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Book {
    private String id;
    private String barcode;
    private String title;
    private String author;
    private String category;
    private Date publicationDate;
    private String rackNumber;
}
