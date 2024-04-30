package org.myllds.librarysystem.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SearchRequest {
    private String type;
    private String member;
    private String library;
    private String title;
    private String author;
    private String category;
    private Date publicationDate;
}
