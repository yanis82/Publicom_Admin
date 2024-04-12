/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.Column;
import utils.validityClass.Email;
import utils.validityClass.Nom;
import utils.validityClass.Prenom;

/**
 *
 * @author 08luc
 */
public class UtilisateurModel extends Model {

    private static final List<Column> columns;
    
    

    public UtilisateurModel() {
        super("UTILISATEUR", columns); // Set table name
    }

    public UtilisateurModel(Nom nom, Prenom prenom, Email email, Boolean isAdmin, String password) throws IllegalArgumentException {
        this();
        super.set(getColumnByEnum(TABLESENUM.NOM), nom);
        super.set(getColumnByEnum(TABLESENUM.PRENOM), prenom);
        super.set(getColumnByEnum(TABLESENUM.EMAIL), email);
        super.set(getColumnByEnum(TABLESENUM.ISADMIN), isAdmin);
        super.set(getColumnByEnum(TABLESENUM.MDP), password);
    }
    
    public UtilisateurModel(String nom, String prenom, String email, Boolean isAdmin, String password) throws IllegalArgumentException {
        this(new Nom(nom), new Prenom(prenom), new Email(email), isAdmin, password);
    }
    
    
    // Static \\
    
    public static enum TABLESENUM {
        ID,
        NOM,
        PRENOM,
        EMAIL,
        ISADMIN,
        MDP
    }

    public static String getColumnByEnum(TABLESENUM column) {
        return switch (column) {
            case ID ->
                "IDUTILISATEUR";
            case NOM ->
                "NOMUTILISATEUR";
            case PRENOM ->
                "PRENOMUTILISATEUR";
            case EMAIL ->
                "EMAILUTILISATEUR";
            case ISADMIN ->
                "ISADMIN";
            case MDP ->
                "MDPUTILISATEUR";
        };
    }

    static {
        List<Column> cols = new ArrayList<>();
        cols.add(Column.ofInt(getColumnByEnum(TABLESENUM.ID))); // Use Columns class for type safety
        cols.add(Column.of(getColumnByEnum(TABLESENUM.NOM), Nom.class)); // Specify char length for string columns
        cols.add(Column.of(getColumnByEnum(TABLESENUM.PRENOM), Prenom.class));
        cols.add(Column.of(getColumnByEnum(TABLESENUM.EMAIL), Email.class));
        cols.add(Column.ofBool(getColumnByEnum(TABLESENUM.ISADMIN)));
        cols.add(Column.ofString(getColumnByEnum(TABLESENUM.MDP)));
        columns = Collections.unmodifiableList(cols);
    }
    
    // Public \\

    @Override
    public int getId() {
        return (int) super.get(getColumnByEnum(TABLESENUM.ID));
    }
    
    public List<Object> getValues (){
        ArrayList<Object> values = new ArrayList<>();
        Object nom = super.get(getColumnByEnum(TABLESENUM.NOM));
        Object prenom = super.get(getColumnByEnum(TABLESENUM.PRENOM));
        Object email = super.get(getColumnByEnum(TABLESENUM.EMAIL));
        Object isAdmin = super.get(getColumnByEnum(TABLESENUM.ISADMIN));
        Object mdp = super.get(getColumnByEnum(TABLESENUM.MDP));
        values.add(nom);
        values.add(prenom);
        values.add(email);
        values.add(isAdmin);
        values.add(mdp);
        
        /*
         * Ici je parcours ma liste et je regarde si les elements sont de type ValidityClass
         * Si oui je ne pourrai pas l'utiliser dans mon sql donc je recupere sa valeur sous un type primitif (int, string...)
         * sinon je garde le meme
         * le tout retourne un map que je pourrai transformer en liste pour avoir une liste sans ValidityClass
         */
        return values;
    }
    
    public void setId(int id) {
        super.set(getColumnByEnum(TABLESENUM.ID), id);
    }

    // Add getter and setter methods for each field (optional)
    // Example getter
//    public int getIdUtilisateur() {
//        UtilisateurModel.columns
//    }
}
