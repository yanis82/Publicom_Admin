/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utilisateur;

import DAO.MysqlConnector;
import DAO.UtilisateurDao;
import Model.UtilisateurModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MainUtilisateurTest {

    public MainUtilisateurTest() {
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
    public void testGetAllUtilisateur() throws SQLException {
        assertDoesNotThrow(() -> UtilisateurDao.getAllUtilisateur());
    }

    @Test
    public void testCreate() throws SQLException {
        UtilisateurModel utilisateurModel = new UtilisateurModel("Dupont", "Jean", "jean.dupont@email.com", false, "motdepasse");

        // Créer l'utilisateur
        UtilisateurDao dao = new UtilisateurDao() {
        };
        utilisateurModel = dao.create(utilisateurModel);

        // Vérifier que l'ID a été généré
        assertNotNull(utilisateurModel.getId());

        // Vérifier que l'utilisateur a été inséré en base de données
        UtilisateurModel utilisateurLu = dao.get(utilisateurModel.getId());
        dao.delete(utilisateurModel);
        assertEquals(utilisateurModel.getId(), utilisateurLu.getId());
        assertEquals(utilisateurModel.getNom(), utilisateurLu.getNom());
        assertEquals(utilisateurModel.getPrenom(), utilisateurLu.getPrenom());
        assertEquals(utilisateurModel.getEmail(), utilisateurLu.getEmail());
        assertEquals(utilisateurModel.getIsAdmin(), utilisateurLu.getIsAdmin());
        assertEquals(utilisateurModel.getMotDePasse(), utilisateurLu.getMotDePasse());
    }

    @Test
    public void testDelete() throws SQLException {
        UtilisateurModel utilisateurModel = new UtilisateurModel("Martin", "Pierre", "pierre.martin@email.com", true, "motdepasse");

        // Créer l'utilisateur
        UtilisateurDao dao = new UtilisateurDao() {
        };
        utilisateurModel = dao.create(utilisateurModel);

        // Supprimer l'utilisateur
        dao.delete(utilisateurModel);

        // Vérifier que l'utilisateur a été supprimé
        UtilisateurModel utilisateurLu = dao.get(utilisateurModel.getId());
        assertNull(utilisateurLu);
    }

    @Test
    public void testGetAll() throws SQLException {
        UtilisateurModel utilisateur1 = new UtilisateurModel("Durand", "Paul", "paul.durant@email.com", false, "motdepasse1");
        UtilisateurModel utilisateur2 = new UtilisateurModel("Leroy", "Marie", "marie.leroy@email.com", true, "motdepasse2");

        // Créer les utilisateurs
        UtilisateurDao dao = new UtilisateurDao() {
        };
        utilisateur1 = dao.create(utilisateur1);
        utilisateur2 = dao.create(utilisateur2);

        // Récupérer tous les utilisateurs
        ArrayList<UtilisateurModel> utilisateurs = dao.getAll();
        System.out.println("utilisateurs : \n" + utilisateurs);
        System.out.println("utilisateur1: \n" + utilisateur1);
        System.out.println("utilisateur2: \n" + utilisateur2);
        // Vérifier que la liste contient les deux utilisateurs
        assertEquals(dao.count(), utilisateurs.size());
        // Vérifier que la liste contient les deux utilisateurs
        boolean containsUtilisateur1 = false;
        boolean containsUtilisateur2 = false;
        for (UtilisateurModel utilisateur : utilisateurs) {
            if (utilisateur.equals(utilisateur1)) {
                containsUtilisateur1 = true;
            } else if (utilisateur.equals(utilisateur2)) {
                containsUtilisateur2 = true;
            }
        }

        assertTrue(containsUtilisateur1);
        assertTrue(containsUtilisateur2);
    }

}
