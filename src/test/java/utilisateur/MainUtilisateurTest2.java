/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import Model.MysqlConnector;
import Model.UtilisateurModel;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author L.sanchez
 */
public class MainUtilisateurTest2 {

    public MainUtilisateurTest2() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testConnection() {
        try {
            ArrayList<UtilisateurModel> utilisateurs = UtilisateurModel.getAllUtilisateur();
            System.out.println(utilisateurs);
            assert (true);
        } catch (SQLException ex) {
            Logger.getLogger(MainUtilisateurTest.class.getName()).log(Level.SEVERE, null, ex);
            assert (false);
        }
    }

    @Test
    public void testGetAllUtilisateur() throws SQLException {
        assertDoesNotThrow(() -> UtilisateurModel.getAllUtilisateur());
    }
}
