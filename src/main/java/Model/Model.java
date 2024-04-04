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
    
    public List<String> getColumnsStr() {
        List<String> maliste = columns.stream().map((column) -> column.getName()).collect(Collectors.toList());
        return maliste;
    }

    public void set(String columnName, Object value) throws IllegalArgumentException{
        if (!this.row.containsKey(columnName)) {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
        this.row.put(columnName, value);
    }

    public Object get(String columnName) throws IllegalArgumentException{
        if (!this.row.containsKey(columnName)) {
            throw new IllegalArgumentException("Column " + columnName + " not found in model");
        }
        return this.row.get(columnName);
    }
    
    
    
    public abstract List<Object> getValues ();
    public abstract void setId(int id);

    @Override
    public String toString() {
        return this.row.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
