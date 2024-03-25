package utils.sql;


import utils.sql.SchemaElement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l.sanchez
 */

class SchemaElementAdapter implements SchemaElement {
    private String tableName;
    private String columnName;

    private String alias = null;
    private SortOrder sortOrder = null;
    private boolean required = true;

    SchemaElementAdapter(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    SchemaElementAdapter(String tableName, String columnName, String alias) {
        this(tableName, columnName);

        this.alias = alias;
    }

    SchemaElementAdapter(String tableName, String columnName, SortOrder sortOrder) {
        this(tableName, columnName);

        this.sortOrder = sortOrder;
    }

    SchemaElementAdapter(String tableName, String columnName, boolean required) {
        this(tableName, columnName);

        this.required = required;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public SortOrder getSortOrder() {
        return sortOrder;
    }

    @Override
    public boolean isRequired() {
        return required;
    }
}