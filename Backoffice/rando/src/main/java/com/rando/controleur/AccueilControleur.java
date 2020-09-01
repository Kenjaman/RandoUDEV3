package com.rando.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rando.dto.UtilisateurDto;

@Controller
public class AccueilControleur {

	@GetMapping({"/", "/accueil"})
	public String accueillir(@ModelAttribute UtilisateurDto utilisateurDto) {
		return "accueil";
	}
	
}
