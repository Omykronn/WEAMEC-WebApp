/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.repository;

import fr.weamec.projectsManager.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour User
 * @author simon
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Trouve un utilisateur par son nom
     * @param username Nom de l'utilisateur
     * @return Utilisateur associé au nom fourni
     */
    public User findByUsername(String username);
}