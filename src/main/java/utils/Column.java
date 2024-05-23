/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDate;

/**
 *
 * @author 08luc
 */
public class Column {

    private final String name;
    private final Class<?> type;

    public Column(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public static Column of(String name, Class<?> type) {
        return new Column(name, type);
    }

    public static Column ofString(String name) {
        return Column.of(name, String.class);
    }

    public static Column ofInt(String name) {
        return Column.of(name, Integer.class);
    }

    public static Column ofBool(String name) {
        return Column.of(name, Boolean.class);
    }

    public static Column ofDate(String name) {
        return Column.of(name, LocalDate.class);
    }

    @Override
    public String toString() {
        return "Column{" + "\n\tname=" + name + ", \n\ttype=" + type + "\n}";
    }

}
