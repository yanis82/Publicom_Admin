/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.Column;
import utils.validityClass.ValidityClass;

/**
 *
 * @author 08luc
 */
public abstract class Model {

    protected final String table;
    private final List<Column> columns;
    protected Map<String, Object> row;

    protected Model(String table, List<Column> columns) {
        this.table = table;
        this.columns = columns;
        this.row = new HashMap<>();
        for (Column column : columns) {
            this.row.put(column.getName(), null);
        }
    }

    public String getTable() {
        return table;
    }

    public List<Column> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public List<String> getColumnsStr() {
        List<String> maliste = columns.stream().map((column) -> column.getName()).collect(Collectors.toList());
        return maliste;
    }

    public void set(String columnName, Object value) throws IllegalArgumentException {
        System.out.println(String.format("Model.set(%s, %s)", columnName, value));
        if (this.row.containsKey(columnName)) {
            this.row.put(columnName, value);
            //TODO: Verifier si value correspond au type attendue de la column
        } else {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
    }

    public void set(String columnName, ValidityClass value) throws IllegalArgumentException {
        this.set(columnName, value.getValue());
    }

    public Object get(String columnName) throws IllegalArgumentException {
        if (!this.row.containsKey(columnName)) {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
        Object value = this.row.get(columnName);
        return value instanceof ValidityClass ? ((ValidityClass) value).getValue() : value;
    }

    public abstract List<Object> getValues();

    public abstract void setId(int id);

    abstract public int getId();

    @Override
    public String toString() {
        return this.row.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
