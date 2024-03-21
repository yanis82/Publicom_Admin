/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UtilisateurModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L.sanchez
 */
public class UtilisateurDao extends SuperDao<UtilisateurModel> {

    public UtilisateurDao() throws SQLException {}
    
    public UtilisateurModel create(UtilisateurModel utilisateurModel) throws SQLException {
        if (this.emailAlready(utilisateurModel.getEmail())) {
            throw new SQLException("email existe deja en base de données");
        } else {
            // Préparer la requête avec possibilité de récupérer l'ID généré
            String query = String.format("INSERT INTO %s (NOMUTILISATEUR, PRENOMUTILISATEUR, EMAILUTILISATEUR, ISADMIN, MDPUTILISATEUR) VALUES (?, ?, ?, ?, ?)", UtilisateurModel.getTable());
            PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Définir les paramètres de la requête
            stat.setString(1, utilisateurModel.getNom());
            stat.setString(2, utilisateurModel.getPrenom());
            stat.setString(3, utilisateurModel.getEmail());
            stat.setInt(4, utilisateurModel.getIsAdmin() ? 1 : 0);
            stat.setString(5, utilisateurModel.getMotDePasse());

            // Exécuter la requête et récupérer l'ID généré
            int nbLignesModifiees = stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();

            // Vérifier si l'ID a été récupéré
            if (rs != null && rs.next()) {
                int idUtilisateur = rs.getInt(1);
                try {
                    utilisateurModel.addId(idUtilisateur);
                } catch (Exception ex) {
                    Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("ID utilisateur généré : " + idUtilisateur);
                rs.close();
            } else {
                System.out.println("Échec de la récupération de l'ID généré");
            }

            if (utilisateurModel.getId() == null) {
                throw new SQLException();
            }
            // Fermer les ressources
            stat.close();
            return utilisateurModel;
        }
    }

    @Override
    public void delete(UtilisateurModel utilisateurModel) {
        if (utilisateurModel.getId() == null) {
            throw new IllegalArgumentException("L'ID de l'utilisateur est obligatoire");
        }

        String query = "DELETE FROM UTILISATEUR WHERE IDUTILISATEUR = ?";
        try {
            PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query);

            stat.setLong(1, utilisateurModel.getId());
            int nbLignesModifiees = stat.executeUpdate();

            if (nbLignesModifiees != 1) {
                throw new SQLException("L'utilisateur n'a pas été supprimé");
            }
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(UtilisateurModel instance) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<UtilisateurModel> getAll() throws SQLException {
        String query = "SELECT * FROM UTILISATEUR";
        PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query);
        ResultSet rs = stat.executeQuery();

        ArrayList<UtilisateurModel> utilisateurs = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("IDUTILISATEUR");
            String nom = rs.getString("NOMUTILISATEUR");
            String prenom = rs.getString("PRENOMUTILISATEUR");
            String email = rs.getString("EMAILUTILISATEUR");
            boolean isAdmin = rs.getInt("ISADMIN") == 1;
            String motDePasse = rs.getString("MDPUTILISATEUR");

            UtilisateurModel utilisateur = new UtilisateurModel(nom, prenom, email, isAdmin, motDePasse);
            try {
                utilisateur.addId(id);
            } catch (Exception ex) {
                Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            utilisateurs.add(utilisateur);
        }

        rs.close();
        stat.close();
        return utilisateurs;
    }

    public UtilisateurModel get(int id) throws SQLException {
        String query = "SELECT * FROM UTILISATEUR WHERE IDUTILISATEUR = ?";
        PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query);
        stat.setLong(1, id);

        ResultSet rs = stat.executeQuery();

        UtilisateurModel utilisateur = null;
        if (rs.next()) {
            int retrievedId = rs.getInt("IDUTILISATEUR");
            String nom = rs.getString("NOMUTILISATEUR");
            String prenom = rs.getString("PRENOMUTILISATEUR");
            String email = rs.getString("EMAILUTILISATEUR");
            boolean isAdmin = rs.getInt("ISADMIN") == 1;
            String motDePasse = rs.getString("MDPUTILISATEUR");

            utilisateur = new UtilisateurModel(nom, prenom, email, isAdmin, motDePasse);
            try {
                utilisateur.addId(retrievedId);
            } catch (Exception ex) {
                Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        rs.close();
        stat.close();
        return utilisateur;
    }

    public boolean emailAlready(String email) throws SQLException {
        String query = "SELECT COUNT(*) as nbEmail from UTILISATEUR u WHERE u.EMAILUTILISATEUR  = ?;";
        PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query);
        stat.setString(1, email);
        System.out.println(query);
        try {
            int nbEmail = 0;
            ResultSet executedSelect = stat.executeQuery(query);
            if (executedSelect.next()) {
                nbEmail = executedSelect.getInt("nbEmail");
            }

            return nbEmail <= 0;
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int count() throws SQLException {
        String query = String.format("SELECT COUNT(*) FROM %s", UtilisateurModel.getTable());
        PreparedStatement stat = MysqlConnector.getConnexion().prepareStatement(query);

        ResultSet rs = stat.executeQuery();

        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }

        rs.close();
        stat.close();
        return count;
    }

    public static ArrayList<UtilisateurModel> getAllUtilisateur() throws SQLException {
        String sql = String.format("select * from %s u", UtilisateurModel.getTable());
        var connection = MysqlConnector.getConnexion();
        Statement stmt = connection.createStatement();
        var result = stmt.executeQuery(sql);
        ArrayList<UtilisateurModel> allUtilisateur = new ArrayList();

        if (result.next()) {
            var utilisateurList = new UtilisateurModel(result.getInt("IDUTILISATEUR"), result.getString("NOMUTILISATEUR"), result.getString("PRENOMUTILISATEUR"), result.getString("EMAILUTILISATEUR"), result.getBoolean("ISADMIN"), result.getString("MDPUTILISATEUR"));
            allUtilisateur.add(utilisateurList);
        }
        return allUtilisateur;
    }

    public void insertToDb(UtilisateurModel utilisateur) {
        String query = String.format("insert into utilisateur (NOMUTILISATEUR, PRENOMUTILISATEUR, EMAILUTILISATEUR, ISADMIN, MDPUTILISATEUR) values\n"
                + "(\"%s\", \"%s\", \"%s\", %d, \"%s\")", utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getIsAdmin() ? 1 : 0, utilisateur.getMotDePasse());
        System.out.println(query);
        try {
            var stat = MysqlConnector.getConnexion().createStatement();
            Boolean isSuccess = stat.execute(query);
            System.out.println("isSuccess: " + isSuccess);
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void emailAlreadyExistOnDb(UtilisateurModel utilisateur) {
        String query = String.format("SELECT COUNT(*) as nbEmail from utilisateur u \n"
                + "WHERE u.EMAILUTILISATEUR  = '%s';", utilisateur.getEmail());
        System.out.println(query);
        try {
            int nbEmail = 0;
            Statement stat = MysqlConnector.getConnexion().createStatement();
            ResultSet executedSelect = stat.executeQuery(query);
            if (executedSelect.next()) {
                nbEmail = executedSelect.getInt("nbEmail");
            }
            if (nbEmail <= 0) {
                this.insertToDb(utilisateur);
                System.out.println("uilisateur cree");
            } else {
                System.out.println("utilisateur existe deja");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
