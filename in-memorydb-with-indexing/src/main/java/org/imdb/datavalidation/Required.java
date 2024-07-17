package org.imdb.datavalidation;

import org.imdb.exception.DataValidationException;

public class Required implements DataValidationType{
    @Override
    public void validate(String val) {
        if(val.isBlank()) {
            throw new DataValidationException("Data is required");
        }
    }
}
