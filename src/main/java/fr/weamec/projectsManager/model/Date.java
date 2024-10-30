/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

/**
 * Classe représentant une date
 * @author simon
 */
public class Date {
    private int jour;
    private int mois;
    private int annee;
    
    /**
     * Constructeur de Date
     * @param jour  Jour
     * @param mois  Mois
     * @param annee Annee
     * @throws IllegalArgumentException Valeur de jour / mois illicite
     */
    public Date(int jour, int mois, int annee) throws IllegalArgumentException {
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException("Valeur de jour illicite");
        }
        
        if (mois < 1 || mois > 12) {
            throw new IllegalArgumentException("Valeur de mois illicite");
        }
        
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    /**
     * Conversion de la date en chaîne de caractères selon la norme ISO 8601 (compatible avec PostgreSQL)
     * @return Date sous forme de chaîne de caractères
     */
    public String toString() {
        return String.format("%04d", annee) + "-" + String.format("%02d", mois) + "-" + String.format("%02d", jour);
    }
}
