/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.repository;

import fr.weamec.projectsManager.model.Expert;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour Expert
 * @author simon
 */
@Repository
public interface ExpertRepository extends CrudRepository<Expert, Integer> {
}