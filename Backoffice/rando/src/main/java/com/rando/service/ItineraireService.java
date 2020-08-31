package com.rando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.ItineraireDao;
import com.rando.modele.Itineraire;

@Service
public class ItineraireService {
	
	@Autowired
	ItineraireDao itineraireDao;
	
	public List<Itineraire> getItineraires() {
		return itineraireDao.getAllIteneraires();
	}
	
	public Itineraire getItineraire(int itineraireId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void ajouter(ItineraireDao itineraireDto) {
		if(itineraireDto != null && itineraireDao.existe(itineraireDto.getNom())) {
			Itineraire itineraire = new Itineraire();
			itineraire.setNom(itineraireDto.getNom());
			itineraire.setNiveau(itineraireDto.getNiveau());
			itineraire.setEtapeitineraires(itineraireDto.getListEtape());
		}
		
	}
	
	@Transactional
	public boolean modifier(int idItinieraire) {
		if(itineraireDao.getIteneraire(idItinieraire)!=null)
		return false;
		
	}

	

}
