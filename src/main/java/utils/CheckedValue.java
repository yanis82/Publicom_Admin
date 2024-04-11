package utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 08luc
 */
public class CheckedValue {

    private String message;
    private boolean isOk;

    public CheckedValue(String message, boolean isOk) {
        this.isOk = isOk;
        this.message = message;
    }

    public String getMessage() {
        if (this.isOk) {
            return "Le mot de passe est correcte";
        } else {
            return message;
        }
    }

    public boolean isValid() {
        return isOk;
    }
}
