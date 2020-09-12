package com.rando.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.EtapeItineraireDao;
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

	@Autowired
	EtapeItineraireDao etapeItineraireDao;

	public List<Itineraire> getItineraires() {
		return itineraireDao.getAllIteneraires();
	}

	public Itineraire getItineraire(int itineraireId) {
		return itineraireDao.getIteneraire(itineraireId);
	}

	@Transactional
	public int ajouter(ItineraireDto itineraireDto) throws AfficheMessageException {
		if (itineraireDao.existe(itineraireDto.getNom())) {
			throw new AfficheMessageException("Un itineraire avec le même nom existe deja");
		} else {
//		if(itineraireDto != null && itineraireDao.existe(itineraireDto.getNom())) {
			if (itineraireDto != null) {
				int ordreEtapes = 1;
				Itineraire itineraire = new Itineraire();
				itineraire.setNom(itineraireDto.getNom());
				itineraire.setNiveau(itineraireDto.getNiveau());

				// TODO boucle sur les etapes avec addEtapeItineraire
				for (Etape e : itineraireDto.getEtapes()) {
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
		}
		return 0;
	}

	//Fonctionne uniquement si pas d'etape incluse
	@Transactional
	public void modifierDetail(int itineraireId, ItineraireDto itineraireDto) throws AfficheMessageException {
		if (!itineraireDao.existe(itineraireDto.getNom())) {
			Itineraire itineraire = itineraireDao.getIteneraire(itineraireId);
			System.out.println("ITI =>>> " + itineraire.toString() + " et " + itineraireId);
			if (itineraire.getEtapeitineraires().size() != 0) {
				int ordreEtapes = 1;
				System.out.println("ITI2 =>>> " + itineraire.getEtapeitineraires().size() + " et "
						+ itineraire.getEtapeitineraires().toString());
				List<Etapeitineraire> allEtapesInItineraire = new ArrayList<Etapeitineraire>();
				List<Etapeitineraire> allEtapes = etapeItineraireDao.getAllEtapeItineraireByIdItineraire(itineraireId);
				System.out.println("ALL =>>> " + allEtapes);

				for (Etape e : itineraireDto.getEtapes()) {
					Etapeitineraire ei = new Etapeitineraire();
					ei.setEtape(e);
					ei.setNumEtape(ordreEtapes);
					ei.setItineraire(itineraire);
					allEtapesInItineraire.add(ei);
					ordreEtapes++;
				}
				for (Etapeitineraire etapeitineraire : allEtapes) {
				itineraire.removeEtapeitineraire(etapeitineraire);
			}
				itineraire.setEtapeitineraires(allEtapesInItineraire);
			}
			itineraireDao.modifierItineraire(itineraireId, itineraireDto);
		} else {
			throw new AfficheMessageException("Ce nom d'itinéraire existe déja");
		}

	}

	// TODO : modifEtape itineraire
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
