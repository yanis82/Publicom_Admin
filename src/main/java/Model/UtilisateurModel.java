/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import DAO.MysqlConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 08luc
 */
public class UtilisateurModel {

    /**
     * @param args the command line arguments
     */
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Boolean isAdmin;
    private String motDePasse;

    public UtilisateurModel(Integer id, String nom, String prenom, String email, Boolean isAdmin, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.isAdmin = isAdmin;
        this.motDePasse = motDePasse;
    }

    public UtilisateurModel(String nom, String prenom, String email, Boolean isAdmin, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.isAdmin = isAdmin;
        this.motDePasse = motDePasse;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public String toString() {
        return "UtilisateurModel{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", isAdmin=" + isAdmin + ", motDePasse=" + motDePasse + "}\n";
    }

    @Override
    public boolean equals(Object utilisateur) {
        if (this == utilisateur) {
            return true; // Reflexivity: an object is always equal to itself
        }
        if (utilisateur == null || getClass() != utilisateur.getClass()) {
            return false; // Objects of different classes or null are not equal
        }
        UtilisateurModel other = (UtilisateurModel) utilisateur;
        // Compare significant fields for equality:
        return Objects.equals(id, other.id)
                && Objects.equals(nom, other.nom)
                && Objects.equals(prenom, other.prenom)
                && Objects.equals(email, other.email)
                && Objects.equals(isAdmin, other.isAdmin);
        // Exclude password from comparison for security reasons
    }

    public static ArrayList<UtilisateurModel> getAllUtilisateur() throws SQLException {
        String sql = "select * from UTILISATEUR u";
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

    public void synchronyze() {
        this.emailAlreadyExistOnDb();
    }

    public void insertToDb() {
        String query = String.format("insert into utilisateur (NOMUTILISATEUR, PRENOMUTILISATEUR, EMAILUTILISATEUR, ISADMIN, MDPUTILISATEUR) values\n"
                + "(\"%s\", \"%s\", \"%s\", %d, \"%s\")", this.nom, this.prenom, this.email, this.isAdmin ? 1 : 0, this.motDePasse);
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

    public void emailAlreadyExistOnDb() {
        String query = String.format("SELECT COUNT(*) as nbEmail from utilisateur u \n"
                + "WHERE u.EMAILUTILISATEUR  = '%s';", this.email);
        System.out.println(query);
        try {
            int nbEmail = 0;
            Statement stat = MysqlConnector.getConnexion().createStatement();
            ResultSet executedSelect = stat.executeQuery(query);
            if (executedSelect.next()) {
                nbEmail = executedSelect.getInt("nbEmail");
            }
            if (nbEmail <= 0) {
                this.insertToDb();
                System.out.println("uilisateur cree");
            } else {
                System.out.println("utilisateur existe deja");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void addId(Integer id) throws Exception {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new Exception("utilisateur a déjà un identifiant");
        }
    }
}
