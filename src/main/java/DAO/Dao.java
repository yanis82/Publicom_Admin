/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 08luc
 */
interface Dao<T> {
    public abstract T create(T model) throws SQLException;
    public abstract void delete(T model) throws SQLException;
    public abstract void update(T model) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
}
