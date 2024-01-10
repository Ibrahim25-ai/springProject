package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMembreService;

import lombok.AllArgsConstructor;

@Controller
@ResponseBody
@RequestMapping("/membres")
@AllArgsConstructor
@CrossOrigin
public class MembreController {

	private IMembreService memberService;

	@GetMapping(value = "/")
	public List<Membre> findAll() {
		return memberService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Membre findById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return memberService.findByCin(cin);
	}

	@PostMapping(value = "/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}

	@PostMapping(value = "/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@PutMapping(value = "/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
	}
	
	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id)
	{

	Membre mbr=memberService.findMember(id);
	mbr.setPubs(memberService.findPublicationparauteur(id));
	mbr.setOutils(memberService.findOutilparauteur(id));
   mbr.setEvnts(memberService.findEvenementparauteur(id));

	return mbr;
	}

}
