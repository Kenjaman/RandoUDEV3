package com.rando.controleur;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rando.dto.EtapeDto;
import com.rando.dto.EtapeItineraireDto;
import com.rando.dto.ItineraireDto;
import com.rando.modele.Etape;
import com.rando.modele.Etapeitineraire;
import com.rando.modele.Niveau;
import com.rando.service.AfficheMessageException;
import com.rando.service.EtapeService;
import com.rando.service.ItineraireService;

/**
 * @author kenan.roux
 *
 */
@Controller
public class ItineraireControleur {

	@Autowired
	private ItineraireService itineraireService;
	@Autowired
	private EtapeService etapeService;

	// Consultation

	/**
	 * @param model
	 * @return
	 * Méthode pour afficher la liste de tous les itinéraires
	 */
	@GetMapping("/itineraires")
	public String getListeItineraires(Model model, HttpSession session, HttpServletRequest request) {
		String key = null;
		if ((String) session.getAttribute("key") != null) {
			key = (String) session.getAttribute("key");
			session.setAttribute("key", key);
		}
		if (request.getParameter("itineraireKey") != null) {
			key = request.getParameter("itineraireKey");
			session.setAttribute("key", key);
		}
		System.out.println("KEY =>>> " + key);
		session.setAttribute("nbEtapes", etapeService.getAllEtapes().size());
		session.setAttribute("nbItineraires", itineraireService.getItineraires().size());
		model.addAttribute("itineraires", itineraireService.getItineraires());
		return "itineraires";
	}

	/**
	 * @param model
	 * @param itineraireId
	 * @param etapeItineraireDto
	 * @return
	 * Méthode pour afficher les détails d'un itinéraire
	 */
	@GetMapping("/itineraire/{itineraireId}")
	public String getDetailItineraire(Model model, @PathVariable Integer itineraireId, @ModelAttribute EtapeItineraireDto etapeItineraireDto) {
		model.addAttribute("itineraire", itineraireService.getItineraire(itineraireId));
		model.addAttribute("etapes", etapeService.getAllEtapes());
		return "itineraire";
	}

	// Creation

	/**
	 * @param model
	 * @param itineraireDto
	 * @return
	 * Méthode pour afficher le formulaire de création d'un itinéraire 
	 */
	@GetMapping("/ajoutItineraire")
	public String ajouterItineraire(Model model, @ModelAttribute ItineraireDto itineraireDto) {
		try {
			List<Etape> allEtapes = new ArrayList<Etape>();
			allEtapes = etapeService.getAllEtapes();
			model.addAttribute("etapes", allEtapes);
			model.addAttribute("niveau", Niveau.values());
			return "ajoutItineraire";
		} catch (Exception e) {
			model.addAttribute("msgEchecAffichageItineraire", e.getMessage());
			return "redirect:/itineraires";
		}

	}

	/**
	 * @param model
	 * @param itineraireDto
	 * @param bindingResult
	 * @throws AfficheMessageException
	 * @return 
	 * Méthode qui permet de valider la création d'un itinéraire
	 */
	@PostMapping("/ajoutItineraire")
	public String ajouterItineraire(Model model, @Valid @ModelAttribute ItineraireDto itineraireDto,
			BindingResult bindingResult,HttpSession session) {
		if (bindingResult.hasErrors()) {
			System.out.println("ya erreur :");
			for (ObjectError oe : bindingResult.getAllErrors())
				System.out.println(oe.getCode());
			//			return ajouterItineraire(model, itineraireDto);
			model.addAttribute("itineraires", itineraireService.getItineraires());
			model.addAttribute("messageEchecAjoutItineraire", "Un itineraire avec le même nom existe deja");
			return "ajoutItineraire";
		} else {
			try {
				System.out.println();
				List<Etape> lesEtapes = itineraireDto.getEtapes();
				for (Etape e : itineraireDto.getEtapes())
					System.out.println(e);
				int idCreer;
				idCreer = itineraireService.ajouter(itineraireDto);
				session.setAttribute("nbItineraires", itineraireService.getItineraires().size());
				return "redirect:/itineraire/" + idCreer;
			} catch (AfficheMessageException e1) {
				model.addAttribute("messageEchecAjoutItineraire", e1.getMessage());
				return ajouterItineraire(model, itineraireDto);
				// TODO Auto-generated catch block
				

			}
		}
	}

	// Modification

	/**
	 * @param model
	 * @param itineraireId
	 * @return 
	 * Méthode pour afficher le formulaire de modification d'un itinéraire
	 */
	@GetMapping("/modifItineraire/{itineraireId}")
	public String modifierItineraire(Model model, @PathVariable int itineraireId) {
		model.addAttribute("itineraire", itineraireService.getItineraire(itineraireId));
		model.addAttribute("niveaux", Niveau.values());
		return "itineraire";
	}

	/**
	 * @param model
	 * @param itineraireId
	 * @param itineraireDto
	 * @param bindingResult
	 * @return
	 * Méthode qui permet de valider la modification d'un itinéraire 
	 */
	@PostMapping("/modifItineraireDetail/{itineraireId}")
	public String modifierItineraireDetail(Model model, @PathVariable Integer itineraireId,
			@Valid @ModelAttribute ItineraireDto itineraireDto, BindingResult bindingResult){
		System.out.println("TOTOID =>>> " + itineraireId);
		if (bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return "modifierItineraire";
		} else {
			try {
				itineraireService.modifierDetail(itineraireId,itineraireDto);
				model.addAttribute("msgReussiteModifItineraire", "Itineraire modifier avec succes");
				return "redirect:/itineraire/" + itineraireId;
			} catch (AfficheMessageException e) {
				model.addAttribute("msgEchecModifItineraire",e.getMessage());
				return "redirect:/modifItineraire/{itineraireId}";
			}
//			itineraireService.modifierDetail(itineraireId,itineraireDto);
//			model.addAttribute("msgReussiteModifItineraire","Itineraire modifier avec succes");
//			return "redirect:/itineraire/" + itineraireId;
		}
	}

	@PostMapping("/modifItineraireEtapes/{itineraireId}")
	public String modifierItineraireEtapesl(Model model, @PathVariable int itineraireId,
			@Valid @ModelAttribute ItineraireDto itineraireDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("ya une erreur");
			return "modifierItineraire";
		} else {
			// itineraireService.modifierEtapes(itineraireDto);
			return "redirect:/itineraire/" + itineraireId;
		}
	}

	// Suppression

	@PostMapping("/itineraire/suppression/{itineraireId}")
	public String supprimerItineraire(@PathVariable int itineraireId) {
		itineraireService.supprimer(itineraireId);
		return "redirect:/itineraires";
	}

	// Modification ou Suppression étape dans itinéraire

	@PostMapping("/actionSurEtapeItineraire/{etapeId}")
	public String actionSurEtapeItineraire(Model model, @RequestParam String action,
			@PathVariable Integer etapeId) {
		return "redirect:/itineraire/" + etapeId;
	}

}
