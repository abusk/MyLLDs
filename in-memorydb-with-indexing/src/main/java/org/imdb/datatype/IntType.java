package org.imdb.datatype;

import org.imdb.datatype.DataType;
import org.imdb.exception.MisMatchedDataTypeException;

public class IntType implements DataType {
    @Override
    public void validate(String val) {
        try {
            Integer.parseInt(val);
        } catch (Exception e) {
            throw new MisMatchedDataTypeException("Data type mismatched!");
        }
    }
}
