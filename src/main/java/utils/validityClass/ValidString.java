/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

/**
 *
 * @author 08luc
 */
public class ValidString {
    String validSting;
    
    public ValidString (String libelle, String validString) throws IllegalArgumentException{
        if(validString.length() > 2) {
            this.validSting = validString;
        }else {
            throw new IllegalArgumentException(String.format("%s necessite plus de 2 caracteres", libelle));
        }
    }
}
