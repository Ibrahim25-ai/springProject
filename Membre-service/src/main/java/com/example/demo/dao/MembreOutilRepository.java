package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Id;

public interface MembreOutilRepository extends JpaRepository<Membre_Outil, Membre_Outil_Id> {
	List<Membre_Outil> findByAuteur(Membre auteur);
}