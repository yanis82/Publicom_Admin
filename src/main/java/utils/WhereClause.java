package utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l.sanchez
 */
public class WhereClause {
    private String key, opSymbol;
    private Object value;
    
    public WhereClause(String key, String opSymbol, Object value) {
        this.opSymbol = opSymbol;
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public String getOperator() {
        return opSymbol;
    }   
}
