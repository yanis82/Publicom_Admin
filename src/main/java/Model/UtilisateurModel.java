/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 08luc
 */
public class UtilisateurModel extends Model {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Boolean isAdmin;
    private String motDePasse;

    public UtilisateurModel(Integer id, String nom, String prenom, String email, Boolean isAdmin, String motDePasse) {
        this(nom, prenom, email, isAdmin, motDePasse);
        this.id = id;
    }

    public UtilisateurModel(String nom, String prenom, String email, Boolean isAdmin, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.isAdmin = isAdmin;
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "UtilisateurModel{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", isAdmin=" + isAdmin + ", motDePasse=" + motDePasse + "}\n";
    }

    static public String getTable() {
        return "UTILISATEUR";
    }

    public List<Colonne> getColonnes() {
        List<Colonne> colonnes = new ArrayList<Colonne>();

        colonnes.add(new Colonne("IDUTILISATEUR", int.class));
        colonnes.add(new Colonne("NOMUTILISATEUR", String.class));
        colonnes.add(new Colonne("PRENOMUTILISATEUR", String.class));
        colonnes.add(new Colonne("EMAILUTILISATEUR", String.class));
        colonnes.add(new Colonne("ISADMIN", boolean.class));
        colonnes.add(new Colonne("MDPUTILISATEUR", String.class));
        return colonnes;
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
