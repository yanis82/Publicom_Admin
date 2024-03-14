package Model;

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

    public static Connection getConnexion() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/publicom", "publicomAdmin", "publicomDb");
            } catch (Exception ex) {
                Logger.getLogger(MysqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
