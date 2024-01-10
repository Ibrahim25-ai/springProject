package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Evenement_Id;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Id;

public interface MembreEvenementRepository extends JpaRepository<Membre_Evenement, Membre_Evenement_Id> {
	List<Membre_Evenement> findByAuteur(Membre auteur);
}