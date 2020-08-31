package com.rando.controleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.rando.service.ItineraireService;

@Controller
public class ItineraireControleur {

	@Autowired
	private ItineraireService itineraireService;
	
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
	
	@GetMapping("/AjoutItineraire")
	public String ajouterItineraire(Model model, @Valid @ModelAttribute ItineraireDto itineraireDto, BindingResult binding) {
		if(binding.hasErrors()) {
			return getListItineraires(model, itineraireDto);
		}
		itineraireService.ajouter(itineraireDto.getNom());
		return "redirect:/itineraires";
	}
	
	@GetMapping("/ModifItineraire/{itineraireId}")
	public String modifierItineraire(Model model,@PathVariable int itineraireId) {
		model.addAttribute("itineraire",itineraireService.getItineraire(itineraireId));
		return "itineraire";	
	}
	

	
	
}
