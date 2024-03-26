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
        for(Column column : columns) {
            this.row.put(column.getName(), null);
        }
    }

    public String getTable() {
        return table;
    }

    public List<Column> getColumns() {
        return Collections.unmodifiableList(columns);
    }
    
    public String[] getColumnsStr() {
        List<String> maliste = columns.stream().map((column) -> column.getName()).collect(Collectors.toList());
        return (String[]) maliste.toArray();
    }

    public void set(String columnName, Object value) {
        if (!row.containsKey(columnName)) {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
        row.put(columnName, value);
    }

    public Object get(String columnName) {
        if (!row.containsKey(columnName)) {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
        return row.get(columnName);
    }

    @Override
    public String toString() {
        return row.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
