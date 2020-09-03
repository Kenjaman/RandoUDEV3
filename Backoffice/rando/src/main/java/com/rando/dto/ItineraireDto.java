package com.rando.dto;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.rando.modele.Etape;
import com.rando.modele.Niveau;

public class ItineraireDto {
	private int id;
	private Niveau niveau;
	@NotBlank(message = "Vous devez fournir un nom d'itineraire !")
	private String nom;
	private List<Etape> etapes;


	/**
	 * @return the etapes
	 */
	public List<Etape> getEtapes() {
		return etapes;
	}

	/**
	 * @param etapes the etapes to set
	 */
	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
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

	@Override
	public String toString() {
		String s = "ItineraireDto [id=" + id + ", niveau=" + niveau + ", nom=" + nom + ", etapes=";
		for(Etape e : etapes)
			s = s + etapes;
		s = s+"]";
		return s;
		
	}
	
	

}