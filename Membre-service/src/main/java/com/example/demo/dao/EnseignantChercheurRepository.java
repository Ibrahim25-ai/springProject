package com.example.demo.dao;

import com.example.demo.entities.EnseignantChercheur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long> {
	
	
	List<EnseignantChercheur>findByGrade(String grade);
	List<EnseignantChercheur>findByEtablissement(String etablissement);
	
	
}
