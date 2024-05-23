/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.validityClass;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Y.akhmouch
 */
public class DateNaissance implements ValidityClass {

    private String dateNaissance;

    public DateNaissance(String dateNaissance) throws IllegalArgumentException {
        setDateNaissance(dateNaissance);
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws IllegalArgumentException {
        System.out.println("set date de naissance de :" + dateNaissance);
        if (DateNaissance.isValid(dateNaissance)) {
            this.dateNaissance = dateNaissance.toLowerCase();
        } else {
            throw new IllegalArgumentException("dateNaissance invalide : " + dateNaissance);
        }
    }

    @Override
    public String toString() {
        return this.dateNaissance.toString();
    }

    public String getValue() {
        return this.dateNaissance;
    }

    // Méthodes de validation supplémentaires (optionnel)
    static boolean isValid(String date) {
        // Regex pour valider l'adresse email
        try {
            LocalDate.parse(date);
            System.out.println("date de naissance valdie");
            return true;
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
