package org.imdb.datatype;

import org.imdb.exception.MisMatchedDataTypeException;

public class RangeType implements DataType{
    private int minVal;
    private int maxVal;
    public RangeType(int min, int max) {
        minVal = min;
        maxVal = max;
    }
    @Override
    public void validate(String val) {
        String[] split = val.split("[-]");
        try {
            int lowerRange = Integer.parseInt(split[0].trim());
            int upperRange = Integer.parseInt(split[1].trim());
            if(minVal < lowerRange || maxVal > upperRange ) {
                throw new Exception("Range limit exceeds!");
            }
        } catch (Exception e) {
            throw new MisMatchedDataTypeException("Data type mismatched!");
        }
    }
}
