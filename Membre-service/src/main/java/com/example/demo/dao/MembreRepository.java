package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Membre;
import java.util.List;


public interface MembreRepository extends JpaRepository<Membre, Long> {
	
	
	Membre findByCin(String cin);
	
	List<Membre>findByNomStartingWith(String caractere);
	
	Membre findByEmail(String email);
	

}
