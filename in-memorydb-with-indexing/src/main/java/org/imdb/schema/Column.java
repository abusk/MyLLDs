package org.imdb.schema;

import org.imdb.datatype.DataType;
import org.imdb.datavalidation.DataValidationType;

public class Column {
    private String name;
    private DataType dataType;
    private DataValidationType dataValidationType;

    public Column(String name, DataType dataType, DataValidationType dataValidationType) {
        this.name = name;
        this.dataType = dataType;
        this.dataValidationType = dataValidationType;
    }

    public void validate(String val) {
        dataType.validate(val);
        dataValidationType.validate(val);
    }

    public String getName() {
        return name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public DataValidationType getDataValidationType() {
        return dataValidationType;
    }
}
