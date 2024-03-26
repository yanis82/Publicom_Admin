/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import DAO.MysqlConnector;
import Model.UtilisateurModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author L.sanchez
 */
public class UtilsiateurModelTest {

    public UtilsiateurModelTest() {
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
    public void testUtilisateurModelCreation() {
        UtilisateurModel utilisateur = new UtilisateurModel();
        assertNotNull(utilisateur);
        assertEquals("UTILISATEUR", utilisateur.getTable());
    }

    @Test
    public void testUtilisateurModelSettersAndGetters() {
        UtilisateurModel utilisateur = new UtilisateurModel();
        utilisateur.set("NOMUTILISATEUR", "John Doe");
        utilisateur.set("EMAILUTILISATEUR", "johndoe@example.com");

        assertEquals("John Doe", utilisateur.get("NOMUTILISATEUR"));
        assertEquals("johndoe@example.com", utilisateur.get("EMAILUTILISATEUR"));

        // Test for an invalid column name
        try {
            utilisateur.set("UNKNOWN_COLUMN", "value");
            fail("Expected IllegalArgumentException for unknown column");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}
