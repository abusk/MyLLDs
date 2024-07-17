package org.imdb.exception;

public class RowDataMisMatchedException extends RuntimeException{
    public RowDataMisMatchedException(String message) {
        super(message);
    }
}
