/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import DAO.MysqlConnector;
import DAO.UtilisateurDao;
import Model.UtilisateurModel;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 08luc
 */
public class DaoTest {
    
    public DaoTest() {
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
        assertDoesNotThrow(() -> {
            var connexion = MysqlConnector.getConnexion();
        });
    }
    
    @Test
    public void testInsert() throws SQLException {
        var utilisateurDao = new UtilisateurDao();
        assertDoesNotThrow(() -> utilisateurDao);
        
        utilisateurDao.insert(new UtilisateurModel("Dupont", "Jean", "jean..testDAO@email.com", false, "motdepasse"));
    }
}
