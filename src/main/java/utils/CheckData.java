/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author s.morisset
 */
public class CheckData {

    public CheckData() {

    }

    public static boolean isEmailValid(String email) {
        String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*\\.[a-z]{2,6}$";
        return Pattern.matches(regex, email);
    }

}
