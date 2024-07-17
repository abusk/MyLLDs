# LLD For In Memory DB 
### Requirements
* The user should be able to define columns using the name and data type and can also specify custom validations on them such as the value cannot be null for string column type, the value should be in provided range for integer column type, column value can be required or not, etc.
* The user should be able to create tables using a defined schema, where the schema is a collection of columns with certain validations.
* The user should be able to insert/update/delete data in a table. Any errors during schema validations are to be raised to the user.
* The user should be able to query data using multiple filters on any of the columns.
* The user can create additional indexes on any columns and of any type like reverse, fuzzy, etc and the same should be used for querying.
* In one query, multiple filter criteria can be sent and data needs to be filtered accordingly.
### Entities
* User
* DataBase
* Column
* DataType
* DataValidationType
* Table
* Schema
* Index
### Entity-Relationships
```mermaid
classDiagram
class User {
        userName: string,
        password: string
}
class Database {
        name: string,
        tables: list
        createTable()
        deleteTable()
}
class DataType {
        type: string
        validate()
} 
class IntType {
        minValue:
        maxvalue
        validate()
}
class StringType {
        length:
        validate()
}
class DataValidationType {
        type:
        validate()
}

class Range {
        minvalue:
        maxValue:
        validate()
}
class Schema {
        name: string
        columns: list
        validateRow()
}
class NonNull {
        validate() 
}
class Required {
        validate()
}
class Column {
        name: string
        type: DataType
        validataTye: DataValidationType
        validate()
}
class Table {
        name:
        data: list
        schema: Schema
        indexes: Index
        primarKey: DataType
        
        insert()
        delete(filters)
        createIndex()
        deleteIndex()
        scan(filters)
        scanOnIndex(filters)
}

class Index {
        name: string
        primaryKey:
        indexData:
        insertData()
        removeData()
        getData(filter)
}

class FuzzyIndex {
        separator:
        getData();
}
    Database -- User
    Table --* Database
    Schema --* Table
    Index --* Table
    Column --* Schema
    Column *-- DataType
    DataType <|-- Range
    DataType <|-- IntType
    DataType <|-- StringType
    Column  *-- DataValidationType
    DataValidationType <|-- NonNull
    DataValidationType <|-- Required
    Index <|-- FuzzyIndex
```
### Identify Design Pattern from Entities-Relationships

