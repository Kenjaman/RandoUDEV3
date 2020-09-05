package com.rando.controleur;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeconnexionControleur {
	@GetMapping("/stop")
	public String deconnexion(HttpSession session) {
		session.invalidate();
		return "redirect:/accueil";
	}
}
