package com.rando.dto;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.rando.modele.Etapeitineraire;
import com.rando.modele.Niveau;

public class ItineraireDto {
	private int id;
	private Niveau niveau;
	@NotBlank(message = "Vous devez fournir un nom d'itineraire !")
	private String nom;
	private List<Etapeitineraire> etapeitineraires;

	/**
	 * @return the etapeitineraires
	 */
	public List<Etapeitineraire> getEtapeitineraires() {
		return etapeitineraires;
	}

	/**
	 * @param etapeitineraires the etapeitineraires to set
	 */
	public void setEtapeitineraires(List<Etapeitineraire> etapeitineraires) {
		this.etapeitineraires = etapeitineraires;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the niveau
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
