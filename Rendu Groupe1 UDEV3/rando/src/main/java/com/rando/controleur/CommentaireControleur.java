package com.rando.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rando.dto.CommentaireDto;
import com.rando.service.AfficheMessageException;
import com.rando.service.CommentaireService;

@Controller
public class CommentaireControleur {

	@Autowired
	private CommentaireService commentaireService;
	
	@PostMapping("/commentez/{etapeId}")
	public String validezCommentaireSuEtape(Model model,@ModelAttribute CommentaireDto commentaireDto, @PathVariable Integer etapeId) {
		try {
			commentaireService.validezCommentaireSuEtape(commentaireDto);
		} catch (AfficheMessageException e) {
			model.addAttribute("msgEchecCommentaire", e.getMessage());
		}
		return "redirect:/etape/" + etapeId;
	}
}
