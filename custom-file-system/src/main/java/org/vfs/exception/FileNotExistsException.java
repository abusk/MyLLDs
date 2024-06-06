package org.vfs.exception;

public class FileNotExistsException extends RuntimeException{
    public FileNotExistsException(String messager) {
        super(messager);
    }
}
