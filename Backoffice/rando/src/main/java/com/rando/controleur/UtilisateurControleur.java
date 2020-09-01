package com.rando.controleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rando.dto.UtilisateurDto;
import com.rando.service.AfficheMessageException;
import com.rando.service.UtilisateurService;

@Controller
public class UtilisateurControleur {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping("/authentification")
	public String authentification(Model model, @Valid @ModelAttribute UtilisateurDto utilisateurDto) {
		System.out.println("ici 1");
		boolean result=utilisateurService.getConnectUser(utilisateurDto.getPseudo(), utilisateurDto.getMdp());
		model.addAttribute("statut", result);
		return "redirect:/";
	}
	
	@GetMapping("/renseignement")
	public String renseignement(Model model, @ModelAttribute UtilisateurDto utilisateurDto) {
		return "renseignement";
	}
	
	@PostMapping("/inscription")
	public String inscription(Model model, @Valid @ModelAttribute UtilisateurDto utilisateurDto) {
		try {
			utilisateurService.inscription(utilisateurDto);
			String message = "Inscription réalisée avec succes...connectez-vous";
			model.addAttribute("messageSucces", message);
			return "redirect:/";
		} catch (AfficheMessageException e) {
			model.addAttribute("messageEchec", e.getMessage());
			return "redirect:/renseignement";
		}
	}
}
