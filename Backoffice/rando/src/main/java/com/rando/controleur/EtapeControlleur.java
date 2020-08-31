package com.rando.controleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.rando.dto.EtapeDto;
import com.rando.modele.Niveau;
import com.rando.service.EtapeService;

@Controller
public class EtapeControlleur {

	@Autowired
	private EtapeService etapeService;
	
	//Consultation
	
	@GetMapping("/etapes")
	public String getListeEtapes(Model model) {
		model.addAttribute("etapes", etapeService.getAllEtapes());
		return "etapes";
	}
	
	@GetMapping("/etape/{etapeId}")
	public String getDetailEtape(Model model,@PathVariable int etapeId) {
		model.addAttribute("etape",etapeService.getEtape(etapeId));
		return "etape";	
	}
	
	//Creation
	
	@GetMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @ModelAttribute EtapeDto etapeDto) {
		model.addAttribute("etapes",etapeService.getAllEtapes());
		model.addAttribute("niveau",Niveau.values());
		return "ajouterEtape";
		
	}

	@PostMapping("/ajoutEtape")
	public String ajouterEtape(Model model, @Valid @ModelAttribute EtapeDto etapeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return ajouterEtape(model, etapeDto);
		}else {
			etapeService.ajouter(etapeDto);
			return "redirect:/etape";
		}
	}
	
	//Modification
	
	@GetMapping("/modifEtape/{etapeId}")
	public String modifierEtape(Model model,@PathVariable int etapeId) {
		model.addAttribute("etape",etapeService.getEtape(etapeId));
		model.addAttribute("niveaux", Niveau.values());
		return "etape";	
	}
	
	@PostMapping("/modifEtape/{etapeId}")
	public String modifierEtape(Model model,@PathVariable long etapeId, @Valid @ModelAttribute EtapeDto etapeDto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return "modifierEtape";
		}else {
			etapeService.modifier(etapeDto);
			return "redirect:/etape/"+etapeId;
		}
	}
	
	
	//Suppression
	
	@PostMapping("/etape/suppression")
	public String supprimerEtape(Model model,@ModelAttribute EtapeDto etapeDto) {
		//TODO Suppression d'Etape
		return "redirect:/etapes";
	}

	
	
}
