/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

import java.util.regex.Pattern;

/**
 *
 * @author 08luc
 */
public class Email {

    private String email;

    public Email(String adresseEmail) throws IllegalArgumentException {
        if(this.isValide()) {
            
        this.email = adresseEmail;
        }else {
            throw new IllegalArgumentException("email invalide");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String adresseEmail) {
        this.email = adresseEmail;
    }

    @Override
    public String toString() {
        return email;
    }

    // Méthodes de validation supplémentaires (optionnel)
    private boolean isValide() {
        // Regex pour valider l'adresse email
        return Pattern.matches("[^@]+@[^@]+\\.[^@]+", email);
    }
}
