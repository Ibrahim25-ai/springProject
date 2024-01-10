package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.bean.EvenementBean;
import com.example.demo.bean.OutilBean;
import com.example.demo.bean.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

@Repository
public interface IMembreService {

	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	public Membre findByCin(String cin);

	public Membre findByEmail(String email);

	public List<Membre> findByNom(String nom);

	public List<Etudiant> findByDiplome(String diplome);

	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);

	public Etudiant addEnsToEtudiant(Long idEtd, Long idEns);

	public List<Etudiant> getEtudiantsByEns(Long idEns);

	public void affecterauteurTopublication(Long idauteur, Long idpub);

	public List<PublicationBean> findPublicationparauteur(Long idauteur);
	
	public void affecterauteurToOutil(Long idauteur, Long idpub);

	public List<OutilBean> findOutilparauteur(Long idauteur);
	
	public void affecterauteurToEvenement(Long idauteur, Long idevt);

	public List<EvenementBean> findEvenementparauteur(Long idauteur);

}
