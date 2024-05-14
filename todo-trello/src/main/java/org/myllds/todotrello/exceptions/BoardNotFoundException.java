package org.myllds.todotrello.exceptions;

public class BoardNotFoundException extends Exception{
    public BoardNotFoundException(String message) {
        super(message);
    }
}
