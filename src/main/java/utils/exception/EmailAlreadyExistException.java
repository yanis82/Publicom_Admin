/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.exception;

/**
 *
 * @author 08luc
 */
public class EmailAlreadyExistException extends IllegalArgumentException{
    public EmailAlreadyExistException(String message) {
        super(message);
    }
    
    public EmailAlreadyExistException() {
        this("Email existe déjà");
    }
}
