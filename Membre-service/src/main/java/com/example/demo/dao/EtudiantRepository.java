package com.example.demo.dao;


import com.example.demo.entities.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.EnseignantChercheur;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	List<Etudiant>findByDiplome(String diplome);
	List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
	List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
	
}
