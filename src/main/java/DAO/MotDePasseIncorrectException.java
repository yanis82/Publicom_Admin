/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package DAO;

/**
 *
 * @author s.morisset
 */
public class MotDePasseIncorrectException extends Exception {

    public MotDePasseIncorrectException() {
        super("Le mot de passe ne respecte pas les normes de sécurité.");
    }

    public MotDePasseIncorrectException(String message) {
        super(message);
    }

}

