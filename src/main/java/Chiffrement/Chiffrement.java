/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chiffrement;

/**
 *
 * @author s.morisset
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Chiffrement {

    public static String Chiffrement(String motDePasse) throws NoSuchAlgorithmException {
        // Keccak is not recommended for password hashing (educational purposes only)
        MessageDigest md = MessageDigest.getInstance("Keccak-256");

        // Conversion du mot de passe en octets
        byte[] bytesMotDePasse = motDePasse.getBytes();

        // Calcul du hachage
        byte[] bytesHache = md.digest(bytesMotDePasse);

        // Conversion du hachage en hexadécimal
        StringBuilder sb = new StringBuilder();
        for (byte b : bytesHache) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String motDePasse = "votre_mot_de_passe";
        String hachage = Chiffrement(motDePasse);

        System.out.println("Mot de passe : " + motDePasse);
        System.out.println("Hachage Keccak (non recommandé) : " + hachage);
    }
}
