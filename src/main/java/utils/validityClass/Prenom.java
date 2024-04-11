/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

/**
 *
 * @author 08luc
 */
public class Prenom extends ValidString {
    public Prenom(String prenom) throws IllegalArgumentException{
        super("Le prenom", prenom);
    }
}
