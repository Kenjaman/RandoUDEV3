package com.rando.dto;

import java.util.List;

import com.rando.modele.Etape;
import com.rando.modele.Etapeitineraire;
import com.rando.modele.Itineraire;


public class EtapeItineraireDto {
	
	public List<Etapeitineraire> getEtapesItineraire() {
		// TODO Auto-generated method stub
		return null;
	}

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer numEtape;

	private Etape etape;

	private Itineraire itineraire;

	
	
	//Binding de etapeDto - Etapeitineraire pour ajout/modif d'itineraire
	public static Etapeitineraire valueOf(String id_etape) {
		Etapeitineraire ei = new Etapeitineraire();
		Etape e = new Etape();
		e.setNom(id_etape);
		ei.setEtape(e);
		return ei;
	}

	@Override
	public String toString() {
		return "Etapeitineraire [id=" + id + ", numEtape=" + numEtape + ", etape=" + etape.getId()+" :"+ etape.getNom() + ", itineraire="
				+ itineraire + "]";
	}
	
	

}