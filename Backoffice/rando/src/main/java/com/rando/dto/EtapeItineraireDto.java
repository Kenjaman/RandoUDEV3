package com.rando.dto;

import com.rando.modele.Etape;
import com.rando.modele.Itineraire;

public class EtapeitineraireDto {

	private Integer id;
	private Integer numEtape;
	private Etape etape;
	private Itineraire itineraire;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the numEtape
	 */
	public Integer getNumEtape() {
		return numEtape;
	}
	/**
	 * @param numEtape the numEtape to set
	 */
	public void setNumEtape(Integer numEtape) {
		this.numEtape = numEtape;
	}
	/**
	 * @return the etape
	 */
	public Etape getEtape() {
		return etape;
	}
	/**
	 * @param etape the etape to set
	 */
	public void setEtape(Etape etape) {
		this.etape = etape;
	}
	/**
	 * @return the itineraire
	 */
	public Itineraire getItineraire() {
		return itineraire;
	}
	/**
	 * @param itineraire the itineraire to set
	 */
	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}
	
}
