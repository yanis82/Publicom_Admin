/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import Model.UtilisateurModel;
import java.util.List;
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
    public void testUtilisateurModelCreation() {
        UtilisateurModel utilisateur = new UtilisateurModel();
        assertNotNull(utilisateur);
        assertEquals("UTILISATEUR", utilisateur.getTable());
    }

    @Test
    public void testUtilisateurModelSettersAndGetters() {
        UtilisateurModel utilisateur = new UtilisateurModel();
        utilisateur.set("NOMUTILISATEUR", "Doe");
        utilisateur.set("EMAILUTILISATEUR", "johndoe@example.com");        
        utilisateur.set("PRENOMUTILISATEUR", "John");


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

    @Test
    public void getUtilisateursValues() {
        UtilisateurModel utilisateur = new UtilisateurModel("Doe", "Jhon", "Jhon.doe@gmail.com", Boolean.FALSE, "#Mot2Passe");
        System.out.println("getValues : ");
        List values = utilisateur.getValues();
        System.out.println(values);
        
        System.out.println("\n\t type values :");
        List typeValues = values.stream().map((el) -> el.getClass()).toList();
        System.out.println(typeValues);

    }
}
