package org.imdb.datavalidation;

import org.imdb.datavalidation.DataValidationType;
import org.imdb.exception.DataValidationException;

public class NonNullType implements DataValidationType {
    @Override
    public void validate(String val) {
        if(val == null) {
            throw new DataValidationException("Data Can't be null");
        }
    }
}
