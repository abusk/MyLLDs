package org.myllds.splitwise.exception;

import org.myllds.splitwise.strategy.impl.EqualShare;

public class EqualShareException extends Exception{
    public EqualShareException(String message) {
        super(message);
    }
}
