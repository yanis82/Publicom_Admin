/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author s.morisset
 */
public class Crypt {

    public checkedPassword checkPassword(String password) {
        boolean isValid = true;
        List<String> messages = new ArrayList<String>();
        // Vérifier la longueur du mot de passe
        if (password.length() < 8) {
            isValid = false;
            messages.add("Le mot de passe doit contenir au moins 8 caractères");
        }

        // Vérifier la présence d'un chiffre
        if (!password.matches(".*[0-9].*")) {
            isValid = false;
            messages.add("Le mot de passe doit contenir au moins un chiffre");
        }

        // Vérifier la présence d'une lettre minuscule
        if (!password.matches(".*[a-z].*")) {
            isValid = false;
            messages.add("Le mot de passe doit contenir au moins une lettre minuscule");
        }

        // Vérifier la présence d'une lettre majuscule
        if (!password.matches(".*[A-Z].*")) {
            isValid = false;
            messages.add("Le mot de passe doit contenir au moins une lettre majuscule");
        }

        // Vérifier la présence d'un caractère spécial
        if (!password.matches(".*[@#$%^&+=].*")) {
            isValid = false;
            messages.add("Le mot de passe doit contenir au moins un caractère spécial parmi ?@#$%^&+=");
        }
        StringBuilder message = new StringBuilder();
        if (messages.size() > 0) {
            for (String el : messages) {
                message.append(el).append("\n\t");
            }
        }
        return new checkedPassword(message.toString(), isValid);
    }

    public String hash(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

}
