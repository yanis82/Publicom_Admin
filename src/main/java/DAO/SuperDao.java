/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Colonne;
import Model.Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 08luc
 */
public class SuperDao<T extends Model>{
    private Connection connection;
    
    public SuperDao() throws SQLException {
        this.connection = MysqlConnector.getConnexion();
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void insert(T model) {
        List<Colonne> colonnes = model.getColonnes();
            String query = String.format("INSERT INTO %s (", model.getTable());
            String queryValues = "";
        for(int i = 0; i < colonnes.size(); i++){
            Colonne colonne = colonnes.get(i);
            boolean isLastLoop = i + 1 < colonnes.size();
            
            query += String.format("%s", colonne.getNom());
            query += isLastLoop ? ", " : "";
            queryValues += isLastLoop ? "?, " : '?';
        }
        query += ") VALUES \n";
        query += String.format("(%s)", queryValues);
        System.out.println("insert query : \n " + query);
    }
    
    public void delete(T model) throws SQLException {
        System.out.println("insert");
    }
    
    public void update(T model) throws SQLException {
        System.out.println("update");
    }
    
    public List<T> getAll() throws SQLException {
        System.out.println("getAll");
        return null;
    }
    
    public T get(){
        System.out.println("get");
        return null;
    }
    
    //public abstract T create(T model) throws SQLException;
    //public abstract void delete(T model) throws SQLException;
    //public abstract void update(T model) throws SQLException;
    // public abstract List<T> getAll() throws SQLException;
}
