package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Publication;

@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
	Publication findByTitre(String titre);
	
	List<Publication> findByDate(Date date);
	
	List<Publication> findByLien(String lien);
	
	List<Publication> findByType(String type);


}
