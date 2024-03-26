/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chiffrement;

import java.util.Scanner;
import java.util.regex.Pattern;
import Chiffrement.VerifPassword;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author s.morisset
 */
public class Chiffrement {

    private String motDePasse;

    public Chiffrement() {
        System.out.print("Entrez votre mot de passe : ");
        Scanner scanner = new Scanner(System.in);
        motDePasse = scanner.nextLine();
        VerifPassword verif = new VerifPassword(motDePasse);
        if (!verif.verifPassword()) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères");
        }
    }

    public static String hash(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public static void main(String[] args) {
        Chiffrement demande = new Chiffrement();
        System.out.println("Mot de passe saisi : " + demande.getMotDePasse());
        System.out.println(Chiffrement.hash(demande.getMotDePasse()));
    }

}
