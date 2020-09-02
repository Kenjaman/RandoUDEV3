package com.rando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rando.dao.ItineraireDao;
import com.rando.dto.ItineraireDto;
import com.rando.modele.Itineraire;

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
			Itineraire itineraire = new Itineraire();
			itineraire.setNom(itineraireDto.getNom());
			itineraire.setNiveau(itineraireDto.getNiveau());
			
			//TODO boucle sur les etapes avec addEtapeItineraire
			itineraire.addEtapeitineraire()
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
	
	@Transactional
	public void modifierEtapes(ItineraireDto itineraire) {
		Itineraire itiMaj = itineraireDao.getIteneraire(itineraire.getId());
		itiMaj.setEtapeitineraires(itineraire.getEtapeitineraires());
	}

	@Transactional
    public void supprimer(int itineraireId) {
        Itineraire itineraire = itineraireDao.getIteneraire(itineraireId);
        if (itineraire == null) {
            return;
        }
        itineraireDao.supprimerItineraire(itineraireId);
        
    }
	

}
