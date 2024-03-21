package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private MysqlConnector() {} //static class should not have public constructor

    public static Connection getConnexion() {
        final String PASSWORD = "publicomDb";
        final String USER = "publicomAdmin";
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://172.28.36.14:3306/publicom", USER, PASSWORD);
            } catch (Exception ex) {
                Logger.getLogger(MysqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
