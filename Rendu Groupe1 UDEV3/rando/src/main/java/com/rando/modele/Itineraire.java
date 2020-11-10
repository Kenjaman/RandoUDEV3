package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the Itineraire database table.
 * 
 */
@Entity
@NamedQuery(name = "Itineraire.findAll", query = "SELECT i FROM Itineraire i")
public class Itineraire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private Niveau niveau;

	// bi-directional many-to-one association to Etapeitineraire
	@OrderBy("numEtape ASC")
	@OneToMany(mappedBy = "itineraire",cascade = CascadeType.ALL)
	private List<Etapeitineraire> etapeitineraires = new ArrayList<Etapeitineraire>();

	public Itineraire() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etapeitineraire> getEtapeitineraires() {
		return this.etapeitineraires;
	}

	public void setEtapeitineraires(List<Etapeitineraire> etapeitineraires) {
		this.etapeitineraires = etapeitineraires;
	}

	public Etapeitineraire addEtapeitineraire(Etapeitineraire etapeitineraire) {
		getEtapeitineraires().add(etapeitineraire);
		etapeitineraire.setItineraire(this);

		return etapeitineraire;
	}

	public Etapeitineraire removeEtapeitineraire(Etapeitineraire etapeitineraire) {
		getEtapeitineraires().remove(etapeitineraire);
		etapeitineraire.setItineraire(null);

		return etapeitineraire;
	}

}