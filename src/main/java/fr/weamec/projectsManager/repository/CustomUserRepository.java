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
    public CustomUser findByUsername(String username);
}