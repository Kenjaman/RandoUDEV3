package com.rando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rando.dao.ItineraireDao;
import com.rando.dto.ItineraireDto;
import com.rando.modele.Etape;
import com.rando.modele.Etapeitineraire;
import com.rando.modele.Itineraire;
import com.rando.modele.Utilisateur;

@Service
public class ItineraireService {
	
	@Autowired
	ItineraireDao itineraireDao;
	
	public List<Itineraire> getItineraires() {
		return itineraireDao.getAllIteneraires();
	}
	
	public Itineraire getItineraire(int itineraireId) {
		return itineraireDao.getIteneraire(itineraireId);
	}
	
	@Transactional
	public int ajouter(ItineraireDto itineraireDto) {
//		if(itineraireDto != null && itineraireDao.existe(itineraireDto.getNom())) {
		if(itineraireDto != null) {
			int ordreEtapes=1;
			Itineraire itineraire = new Itineraire();
			itineraire.setNom(itineraireDto.getNom());
			itineraire.setNiveau(itineraireDto.getNiveau());
		
			//TODO boucle sur les etapes avec addEtapeItineraire
			for(Etape e : itineraireDto.getEtapes()) {
				Etapeitineraire ei = new Etapeitineraire();
				ei.setEtape(e);
				ei.setNumEtape(ordreEtapes);
				System.out.println(ei);
				itineraire.addEtapeitineraire(ei);
				ordreEtapes++;
			}
//			itineraire.addEtapeitineraire();
			return itineraireDao.ajouterItineraire(itineraire);
		}
		return 0;
	}
	
	
	@Transactional
	public void modifierDetail(ItineraireDto itineraire) {
		Itineraire itineraireMAJ = itineraireDao.getIteneraire(itineraire.getId());
		itineraireMAJ.setNom(itineraire.getNom());
		itineraireMAJ.setNiveau(itineraire.getNiveau());
	}
	
	//TODO : modifEtape itineraire
//	@Transactional
//	public void modifierEtapes(ItineraireDto itineraire) {
//		Itineraire itiMaj = itineraireDao.getIteneraire(itineraire.getId());
//		itiMaj.setEtapeitineraires(itineraire.getEtapes());
//	}

	@Transactional
    public void supprimer(int itineraireId) {
        Itineraire itineraire = itineraireDao.getIteneraire(itineraireId);
        if (itineraire == null) {
            return;
        }
        itineraireDao.supprimerItineraire(itineraireId);
        
    }
	

}
