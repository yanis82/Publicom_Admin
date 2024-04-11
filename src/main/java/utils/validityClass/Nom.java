/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

/**
 *
 * @author 08luc
 */
public class Nom extends ValidString {
    public Nom(String nom) throws IllegalArgumentException {
        super("Le nom", nom);
    }
}
