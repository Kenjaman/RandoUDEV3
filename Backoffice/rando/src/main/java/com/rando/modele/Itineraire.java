package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the itineraire database table.
 * 
 */
@Entity
@NamedQuery(name="Itineraire.findAll", query="SELECT i FROM Itineraire i")
public class Itineraire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String niveau;

	private String nom;

	//bi-directional many-to-one association to Etapeitineraire
	@OneToMany(mappedBy="itineraire")
	private List<Etapeitineraire> etapeitineraires;

	public Itineraire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
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