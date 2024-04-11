/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import DAO.MysqlConnector;
import DAO.UtilisateurDao;
import Model.UtilisateurModel;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.QueryBuilder;
import utils.validityClass.Email;
import utils.validityClass.Nom;
import utils.validityClass.Prenom;

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
    public void testgetAll() throws SQLException {
        UtilisateurModel utilisateurModel = new UtilisateurModel();
        UtilisateurDao utilisateurDao = new UtilisateurDao(utilisateurModel);
        List<UtilisateurModel> allUtilisateurs = utilisateurDao.getAll();
        for(UtilisateurModel utilisateur : allUtilisateurs) {
            System.out.println(utilisateur);
        }
        Assertions.assertTrue(true);
    }
    @Test
    public void QueryBuilderInsertTest() throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder();
        Nom nom = new Nom("Sanchez");
        Prenom prenom = new Prenom("Lucas");
        Email email = new Email("test@gmail.com");
                
        UtilisateurModel utilisateur = new UtilisateurModel(nom, prenom, email, true, "#jojoJOJODU82");
        List<String> columns = utilisateur.getColumnsStr().subList(1, utilisateur.getColumnsStr().size());
        List<Object> values = utilisateur.getValues();
        System.out.println("values : " + values);
        System.out.println("columns : " + columns);
        int rowAffected = queryBuilder.insertInto(utilisateur.getTable(), columns, values);
        System.out.println("rowAffected : "+ rowAffected);
        assertTrue(true);
    }
    
}
