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


import com.rando.dto.ItineraireDto;
import com.rando.modele.Niveau;
import com.rando.service.EtapeService;
import com.rando.service.ItineraireService;

@Controller
public class ItineraireControleur {

	@Autowired
	private ItineraireService itineraireService;
	private EtapeService etapeService;
	
	//Consultation
	
	@GetMapping("/itineraires")
	public String getListeItineraires(Model model) {
		model.addAttribute("itineraires", itineraireService.getItineraires());
		return "itineraires";
	}
	
	@GetMapping("/itineraire/{itineraireId}")
	public String getDetailItineraire(Model model,@PathVariable int itineraireId) {
		model.addAttribute("itineraire",itineraireService.getItineraire(itineraireId));
		return "itineraire";	
	}
	
	//Creation
	
	@GetMapping("/ajoutItineraire")
	public String ajouterItineraire(Model model, @ModelAttribute ItineraireDto itineraireDto) {
		model.addAttribute("etapes",etapeService.getAllEtapes());
		model.addAttribute("niveau",Niveau.values());
		return "ajouterItineraire";
		
	}

	@PostMapping("/ajoutItineraire")
	public String ajouterItineraire(Model model, @Valid @ModelAttribute ItineraireDto itineraireDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return ajouterItineraire(model, itineraireDto);
		}else {
			itineraireService.ajouter(itineraireDto);
			return "redirect:/itineraire";
		}
	}
	
	//Modification
	
	@GetMapping("/modifItineraire/{itineraireId}")
	public String modifierItineraire(Model model,@PathVariable int itineraireId) {
		model.addAttribute("itineraire",itineraireService.getItineraire(itineraireId));
		model.addAttribute("niveaux", Niveau.values());
		return "itineraire";
	}
	
	@PostMapping("/modifItineraire/{itineraireId}")
	public String modifierItineraire(Model model,@PathVariable int itineraireId, @Valid @ModelAttribute ItineraireDto itineraireDto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return "modifierItineraire";
		}else {
			itineraireService.modifier(itineraireDto);
			return "redirect:/itineraire/"+itineraireId;
		}
	}
	
	
	//Suppression
	
	@PostMapping("/itineraire/suppression/{itineraireId}")
	public String supprimerItineraire(@PathVariable int itineraireId) {
		itineraireService.supprimer(itineraireId);
		return "redirect:/itineraires";
	}

	
	
}
