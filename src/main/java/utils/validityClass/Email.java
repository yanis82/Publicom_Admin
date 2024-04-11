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
public class Email implements ValidityClass<String>{

    private String email;

    public Email(String email) throws IllegalArgumentException {
        if (this.isValide(email)) {

            this.email = email;
        } else {
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
        return this.email;
    }
    
    public String getValue() {
        return this.email;
    }
    
    // Méthodes de validation supplémentaires (optionnel)
    private boolean isValide(String email) {
        // Regex pour valider l'adresse email
        return Pattern.matches("[^@]+@[^@]+\\.[^@]+", email);
    }
}
