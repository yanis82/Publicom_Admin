package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this
 * template
 */
/**
 *
 * @author 08luc
 */
public class MysqlConnector {

    /**
     * @param args the command line arguments
     * @return
     */
    private static Connection con = null;

    private MysqlConnector() { } //static class should not have public constructor

    public static Connection getConnection() throws SQLException {
        final String PASSWORD = "admin";
        final String USER = "admin";
        final String HOST = "172.28.36.1";
        if (con == null) {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/publicom", USER, PASSWORD);
        }
        return con;
    }
}
