package org.imdb.schema;

import org.imdb.datatype.DataType;
import org.imdb.datavalidation.DataValidationType;
import org.imdb.exception.RowDataMisMatchedException;

import java.util.List;

public class Schema {
    private String name;
    private List<Column> columns;

    public Schema(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public void validateRow(String row) {
        String[] split = row.split("[,]");
        if(split.length != columns.size()) {
            throw new RowDataMisMatchedException("Number of column mismatched");
        }
        for(int i = 0; i<columns.size(); i++) {
            Column column = columns.get(0);
            DataType dataType = column.getDataType();
            dataType.validate(split[i]);
            DataValidationType dataValidationType = column.getDataValidationType();
            dataValidationType.validate(split[i]);
        }
    }
}
