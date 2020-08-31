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
	public void ajouter(ItineraireDto itineraireDto) {
		if(itineraireDto != null && itineraireDao.existe(itineraireDto.getNom())) {
			Itineraire itineraire = new Itineraire();
			itineraire.setNom(itineraireDto.getNom());
			itineraire.setNiveau(itineraireDto.getNiveau());
			itineraire.setEtapeitineraires(itineraireDto.getEtapeitineraires());
		}
		
	}
	
	@Transactional
	public void modifier(ItineraireDto itineraire) {
		Itineraire itineraireMAJ = itineraireDao.getIteneraire(itineraire.getId());
		itineraireMAJ.setNom(itineraire.getNom());
		itineraireMAJ.setNiveau(itineraire.getNiveau());
		itineraireMAJ.setEtapeitineraires(itineraire.getEtapeitineraires());
	}

	@Transactional
    public void supprimer(int itineraireId) {
        Itineraire itineraire = itineraireDao.getIteneraire(itineraireId);
        if (itineraire == null) {
            return;
        }
//        if (! itineraire.getAnimaux().isEmpty()) {
//            throw new AnimalExisteEncoreException("Cette espèce a encore des animaux.");
//        }
        itineraireDao.supprimerItineraire(itineraireId);
    }
	

}
