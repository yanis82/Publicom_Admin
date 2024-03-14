package utilisateur;

import Model.UtilisateurModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author 08luc
 */
public class MainUtilisateurTest {

    /**
     * @param args the command line arguments
     */
    @Test
    public static void main(String[] args) {
        //        try (Connection connection = MysqlConnector.getConnection();) {
//            String querySelectAll = "SELECT * From utilisateur u";
//
//            UtilisateurModel lucas = new UtilisateurModel("Sanchez", "Lucas", "lucas2@gmail.com", true, "mot de passe");
//            System.out.println(lucas);
//            lucas.synchronyze();
//        } catch (SQLException ex) {
//            Logger.getLogger(MainUtilisateurTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            ArrayList<UtilisateurModel> utilisateurs = UtilisateurModel.getAllUtilisateur();
            System.out.println(utilisateurs);
        } catch (SQLException ex) {
            Logger.getLogger(MainUtilisateurTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
