package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Evenement;

@RepositoryRestController
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	Evenement findByTitre(String titre);
	
	List<Evenement> findByDate(Date date);
	
	List<Evenement> findByLieu(String lieu);

}
