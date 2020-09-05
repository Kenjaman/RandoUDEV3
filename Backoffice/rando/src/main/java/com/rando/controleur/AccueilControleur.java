package com.rando.controleur;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rando.dto.UtilisateurDto;
import com.rando.service.EtapeService;
import com.rando.service.ItineraireService;

@Controller
public class AccueilControleur {

	@Autowired
	private ItineraireService itineraireService;
	@Autowired
	private EtapeService etapeService;
	
	@GetMapping({"/", "/accueil"})
	public String accueillir(Model model,@ModelAttribute UtilisateurDto utilisateurDto,HttpSession session) {
		session.setAttribute("nbEtapes", etapeService.getAllEtapes().size());
		session.setAttribute("nbItineraires", itineraireService.getItineraires().size());
		model.addAttribute("itineraires", itineraireService.getItineraires());
		return "accueil";
	}
	
}
