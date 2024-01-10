package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.EvenementBean;
import com.example.demo.bean.OutilBean;
import com.example.demo.bean.PublicationBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MembreEvenementRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Evenement;
import com.example.demo.entities.Membre_Evenement_Id;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Id;
import com.example.demo.entities.Membre_Pub_Id;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EvenementProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MembreService implements IMembreService {

	
	MembreRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	MembrePubRepository membrePubRepository;
	PublicationProxyService publicationProxyService;
	MembreOutilRepository membreOutilRepository;
	OutilProxyService outilProxyService;
	MembreEvenementRepository membreEvenementRepository;
	EvenementProxyService evenementProxyService;
	
	public Etudiant addEnsToEtudiant(Long idEtudiant, Long idEnseignant) {
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEnseignant).get();
		Etudiant etd = etudiantRepository.findById(idEtudiant).get();
		etd.setEncadrant(ens);
		return memberRepository.save(etd);
	}

	public Membre addMember(Membre m) {
		
		memberRepository.save(m);
		return m;
		}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
		}
	
	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
		}

	@Override
	public Membre findMember(Long id) {
		return memberRepository.findById(id).isPresent() ? memberRepository.findById(id).get() : null;
	}

	@Override
	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public List<Etudiant> getEtudiantsByEns(Long idEns) {
		EnseignantChercheur ens = enseignantChercheurRepository.findById(idEns).get();
		return etudiantRepository.findByEncadrant(ens);
	}

	public void affecterauteurTopublication(Long idauteur, Long idpub)
	{
	Membre mbr= memberRepository.findById(idauteur).get();
	Membre_Publication mbs= new Membre_Publication();
	mbs.setAuteur(mbr);
	mbs.setId(new Membre_Pub_Id(idpub, idauteur));
	membrePubRepository.save(mbs);
	}

	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs=new ArrayList<PublicationBean>();
		Membre auteur= memberRepository.findById(idauteur).get();
		List< Membre_Publication>
		idpubs=membrePubRepository.findByAuteur(auteur);
		idpubs.forEach(s->{
		System.out.println(s);
		pubs.add(publicationProxyService.findPublicationById(s.getId().getPublication_id()));
		}
		);
		return pubs;
		}
	
	
	public void affecterauteurToOutil(Long idauteur, Long idoutil)
	{
	Membre mbr= memberRepository.findById(idauteur).get();
	Membre_Outil mbo= new Membre_Outil();
	mbo.setAuteur(mbr);
	mbo.setId(new Membre_Outil_Id(idoutil, idauteur));
	membreOutilRepository.save(mbo);
	}

	public List<OutilBean> findOutilparauteur(Long idauteur) {
		List<OutilBean> outils=new ArrayList<OutilBean>();
		Membre auteur= memberRepository.findById(idauteur).get();
		List< Membre_Outil> idoutils=membreOutilRepository.findByAuteur(auteur);
		idoutils.forEach(s->{
		System.out.println(s);
		outils.add(outilProxyService.findOutilById(s.getId().getOutil_id()));
		}
		);
		return outils;
		}

	@Override
	public void affecterauteurToEvenement(Long idauteur, Long idevt) {
		Membre mbr= memberRepository.findById(idauteur).get();
		Membre_Evenement mbo= new Membre_Evenement();
		mbo.setAuteur(mbr);
		mbo.setId(new Membre_Evenement_Id(idevt, idauteur));
		membreEvenementRepository.save(mbo);
		
	}

	@Override
	public List<EvenementBean> findEvenementparauteur(Long idauteur) {
		List<EvenementBean> evnts=new ArrayList<EvenementBean>();
		Membre auteur= memberRepository.findById(idauteur).get();
		List< Membre_Evenement> idevnts=membreEvenementRepository.findByAuteur(auteur);
		idevnts.forEach(s->{
		System.out.println(s);
		evnts.add(evenementProxyService.findOutilById(s.getId().getEvenement_id()));
		}
		);
		return evnts;
	}
	
}
