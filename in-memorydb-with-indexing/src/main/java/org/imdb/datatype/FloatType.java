package org.imdb.datatype;

import org.imdb.exception.MisMatchedDataTypeException;

public class FloatType implements DataType{
    @Override
    public void validate(String val) {
        try {
            Float.parseFloat(val);
        } catch (Exception e) {
            throw  new MisMatchedDataTypeException("Data type mismatched!");
        }
    }
}
