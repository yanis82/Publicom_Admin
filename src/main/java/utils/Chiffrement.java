/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Pattern;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author s.morisset
 */
public class Chiffrement {

    public Chiffrement() {

    }

    public boolean checkPassword(String password) {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }

    public String hash(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

}
