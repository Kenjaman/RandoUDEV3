package com.rando.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rando.modele.Etape;
import com.rando.modele.Itineraire;
import com.rando.modele.Utilisateur;
import com.rando.service.EtapeService;
import com.rando.service.ItineraireService;
import com.rando.service.UtilisateurService;
import org.json.simple.*;

@RestController
@RequestMapping("/api")
public class WebConfigApiControleur {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ItineraireService itineraireService;
	@Autowired
	private EtapeService etapeService;

    @GetMapping(path="/utilisateurs", produces= "application/json")
    public List<Utilisateur> getAllUsers() {
    	List<Utilisateur> users = utilisateurService.getAllUsers();
        return users;
    }
    
    @GetMapping(path="/itineraires", produces= "application/json")
    public List<Itineraire> getItineraires() {
    	List<Itineraire> itineraires = itineraireService.getItineraires();
        return itineraires;
    }
    
    @GetMapping(path="/etapes", produces= "application/json")
    public List<Etape> getAllEtapes() {
    	List<Etape> etapes = etapeService.getAllEtapes();
        return etapes;
    }
    
    @GetMapping(path="/etapes/{idEtape}", produces= "application/json")
    public Etape getEtape(@PathVariable(name = "idEtape") Integer idEtape) {
    	Etape etape = etapeService.getEtape(idEtape);
        return etape;
    }
}
