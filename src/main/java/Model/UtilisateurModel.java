/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.Column;

/**
 *
 * @author 08luc
 */
public class UtilisateurModel extends Model {

    private static final List<Column> columns;

    static {
        List<Column> cols = new ArrayList<>();
        cols.add(Column.ofInteger("IDUTILISATEUR")); // Use Columns class for type safety
        cols.add(Column.ofString("NOMUTILISATEUR")); // Specify char length for string columns
        cols.add(Column.ofString("PRENOMUTILISATEUR"));
        cols.add(Column.ofString("EMAILUTILISATEUR"));
        cols.add(Column.ofInteger("ISADMIN"));
        cols.add(Column.ofString("MDPUTILISATEUR"));
        columns = Collections.unmodifiableList(cols);
    }

    public UtilisateurModel() {
        super("UTILISATEUR", columns); // Set table name
    }
    public UtilisateurModel(String nom, String prenom, String email, boolean isAdmin, String password) {
        this();
        super.set("NOMUTILISATEUR", nom);
        super.set("PRENOMUTILISATEUR", prenom);
        super.set("EMAILUTILISATEUR", email);
        super.set("ISADMIN", isAdmin ? 1 : 0);
        super.set("MDPUTILISATEUR", password);
    }

    // Add getter and setter methods for each field (optional)
    // Example getter
//    public int getIdUtilisateur() {
//        UtilisateurModel.columns
//    }
}
