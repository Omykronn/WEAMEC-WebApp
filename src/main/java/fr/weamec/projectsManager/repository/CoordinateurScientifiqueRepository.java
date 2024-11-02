/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.repository;

import fr.weamec.projectsManager.model.CoordinateurScientifique;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour CoordinateurScientifique
 * @author simon
 */
@Repository
public interface CoordinateurScientifiqueRepository extends CrudRepository<CoordinateurScientifique, Integer> {
}