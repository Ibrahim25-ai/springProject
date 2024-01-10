package com.example.demo.entities;



import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@DiscriminatorValue("ens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantChercheur extends Membre {

	private static final long serialVersionUID = 1L;
	
	
    private String grade;
    private String etablissement;
    
    @Builder
	public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom,
			@NonNull Date dateNaissance, @NonNull String email, @NonNull String password, String grade,
			String etablissement) {
		super(cin, nom, prenom, dateNaissance, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}
    
  
	



   
    
    
}
