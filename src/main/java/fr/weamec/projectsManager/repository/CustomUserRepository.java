/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.repository;

import fr.weamec.projectsManager.model.CustomUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour User
 * @author simon
 */
@Repository
public interface CustomUserRepository extends CrudRepository<CustomUser, Integer> {
    /**
     * Obtient un CustomUser à partir de son nom d'utilisateur depuis la base de données
     * @param username  Nom de l'utilisateur
     * @return          CustomUser associé à username
     */
    public CustomUser findByUsername(String username);
    
    /**
     * Obtient tous les CustomUser de la base de données, triés par ordre décroissant d'identifiant
     * @return  Liste de CustomUser triée par ordre décroissant d'identifiant
     */
    public Iterable<CustomUser> findAllByOrderByIdAsc();
}