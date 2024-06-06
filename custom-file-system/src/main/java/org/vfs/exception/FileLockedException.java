package org.vfs.exception;

public class FileLockedException extends RuntimeException{
    public FileLockedException(String message) {
        super(message);
    }
}
