/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant un utilisateur
 * @author simon
 */
@Entity
@Table(name = "users")
public class CustomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    
    /**
     * Constructeur par défaut
     */
    public CustomUser() {
    }
    
    /**
     * Constructeur de User (sans id)
     * @param username  Nom de l'utilisateur
     * @param password  Condensé du mot de passe de l'utilisateur
     * @param role      Role de l'utilisateur
     */
    public CustomUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    /**
     * id Getter
     * @return Identifiant
     */
    public int getId() {
        return id;
    }
    
    /**
     * id Setter
     * @param id Identifiant 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * username Getter
     * @return Nom de l'utilisateur
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * username Setter
     * @param username Nom de l'utilisateir
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * password Getter
     * @return Condensé du mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     * password Setter
     * @param password Condensé du mot de passe 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * role Getter
     * @return Role
     */
    public String getRole() {
        return role;
    }
    
    /**
     * role Setter
     * @param role Role 
     */
    public void setRole(String role) {
        this.role = role;
    }
}
