/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

import com.google.protobuf.TextFormat;
import java.util.regex.Pattern;

/**
 *
 * @author 08luc
 */
public class Email implements ValidityClass<String> {
    
    private String email;
    
    public Email(String email) throws IllegalArgumentException {
        setEmail(email);
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String adresseEmail) throws IllegalArgumentException {
        System.out.println("setemail de + "  + adresseEmail);
        if (Email.isValid(adresseEmail)) {
            this.email = adresseEmail.toLowerCase();
        } else {
            throw new IllegalArgumentException("email invalide : " + adresseEmail);
        }
    }
    
    @Override
    public String toString() {
        return this.email;
    }
    
    public String getValue() {
        return this.email;
    }

    // Méthodes de validation supplémentaires (optionnel)
    static boolean isValid(String email) {
        // Regex pour valider l'adresse email
        return Pattern.matches("[^@]+@[^@]+\\.[^@]+", email);
    }
    
    public static Email cast(String value) throws TextFormat.ParseException {
        // Implement validation logic here to ensure the String is a valid email address
        // You can use regular expressions or other validation techniques

        if (Email.isValid(value)) {
            return new Email(value);
        } else {
            throw new TextFormat.ParseException("Invalid email format");
        }
        
    }
}
