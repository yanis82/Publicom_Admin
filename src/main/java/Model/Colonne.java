/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 08luc
 */
public class Colonne {
        private String nom;
        private Class<?> type;

        public Colonne(String nom, Class<?> type) {
            this.nom = nom;
            this.type = type;
        }

        public String getNom() {
            return nom;
        }

        public Class<?> getType() {
            return type;
        }
    }
