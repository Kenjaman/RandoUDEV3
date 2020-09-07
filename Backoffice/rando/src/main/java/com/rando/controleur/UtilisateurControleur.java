package com.rando.controleur;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rando.dto.UtilisateurDto;
import com.rando.service.AfficheMessageException;
import com.rando.service.ItineraireService;
import com.rando.service.UtilisateurService;

@Controller
public class UtilisateurControleur {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ItineraireService itineraireService;

	@PostMapping("/authentification")
	public String authentification(Model model, @Valid @ModelAttribute UtilisateurDto utilisateurDto, HttpSession session) {
		System.out.println("ici 1 " + utilisateurDto.getPseudo() + " " + utilisateurDto.getMdp());
		boolean result = utilisateurService.getConnectUser(utilisateurDto.getPseudo(), utilisateurDto.getMdp());
		if(result==true) {
			session.setAttribute("moi", utilisateurDto.getPseudo());
		}
		model.addAttribute("itineraires", itineraireService.getItineraires());
		model.addAttribute("statut", result);
		return "itineraires";
	}

	@GetMapping("/logMe")
	public String afficherPageConnexion(Model model) {
		return "logMe";
	}
	
	@GetMapping("/renseignement")
	public String renseignement(Model model, @ModelAttribute UtilisateurDto utilisateurDto) {
		return "renseignement";
	}

	@PostMapping("/inscription")
	public String inscription(Model model, @Valid @ModelAttribute UtilisateurDto utilisateurDto) {
		System.out.println("ici 2 " + utilisateurDto.getPseudo() + " " + utilisateurDto.getMdp());
		try {
			utilisateurService.inscription(utilisateurDto);
			String message = "Inscription réalisée avec succes...connectez-vous";
			model.addAttribute("messageSucces", message);
			return "accueil";
		} catch (AfficheMessageException e) {
			model.addAttribute("messageEchec", e.getMessage());
			return "redirect:/renseignement";
		}
	}
}
