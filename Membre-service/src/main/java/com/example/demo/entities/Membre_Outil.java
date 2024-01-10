package com.example.demo.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
public class Membre_Outil {
	
	@EmbeddedId
	private Membre_Outil_Id id;
	@ManyToOne @MapsId("auteur_id")
	private Membre auteur;

}
