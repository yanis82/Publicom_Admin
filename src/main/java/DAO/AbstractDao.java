/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 08luc
 */
public abstract class AbstractDao<T> {
    public abstract T create(T utilisateurModel) throws SQLException;
    public abstract void delete(T utilisateurModel) throws SQLException;
    public abstract void update(T utilisateurModel) throws SQLException;
    public abstract ArrayList<T> getAll() throws SQLException;
}
