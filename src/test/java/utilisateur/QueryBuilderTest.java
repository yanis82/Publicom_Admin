/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import Model.UtilisateurModel;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.QueryBuilder;

/**
 *
 * @author 08luc
 */
public class QueryBuilderTest {
    
    public QueryBuilderTest() {
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
    public void insertIntoTest () throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder();
        UtilisateurModel utilisateurModel = new UtilisateurModel("Sanchez", "Lucas", "lucas@mail.com", true, "##mot de passe fort##");
        System.out.println("table: " + utilisateurModel.getTable());
        assertDoesNotThrow(() -> queryBuilder.insertInto(utilisateurModel.getTable(), "'Sanchez'", "'Lucas'", "'lcuas@gmail.com'", "1", "'#mdpFort#'"));
    }
}
