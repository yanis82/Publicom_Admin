
import Model.UtilisateurModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 08luc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UtilisateurModel lucas = new UtilisateurModel("Sanchez", "Lucas", "lucas2@gmail.com", true, "mot de passe");
        System.out.println(lucas);
        lucas.synchronyze();
    }
    
}
