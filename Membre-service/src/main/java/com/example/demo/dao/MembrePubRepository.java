package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;

import java.util.List;


public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
	List<Membre_Publication> findByAuteur(Membre auteur);
}