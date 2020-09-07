package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the etape database table.
 * 
 */
@Entity
@NamedQuery(name="Etape.findAll", query="SELECT e FROM Etape e")
public class Etape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String nom;

	@Column(name="nb_like")
	private Integer nbLike;

	//bi-directional many-to-one association to Etapeitineraire
	@OneToMany(mappedBy="etape")
	@JsonIgnore
	private List<Etapeitineraire> etapeitineraires;

	public Etape() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbLike() {
		return this.nbLike;
	}

	public void setNbLike(Integer nbLike) {
		this.nbLike = nbLike;
	}


	public List<Etapeitineraire> getEtapeitineraires() {
		return this.etapeitineraires;
	}

	public void setEtapeitineraires(List<Etapeitineraire> etapeitineraires) {
		this.etapeitineraires = etapeitineraires;
	}

	public Etapeitineraire addEtapeitineraire(Etapeitineraire etapeitineraire) {
		getEtapeitineraires().add(etapeitineraire);
		etapeitineraire.setEtape(this);

		return etapeitineraire;
	}

	public Etapeitineraire removeEtapeitineraire(Etapeitineraire etapeitineraire) {
		getEtapeitineraires().remove(etapeitineraire);
		etapeitineraire.setEtape(null);

		return etapeitineraire;
	}

	//Binding de etapeDto - Etapeitineraire pour ajout/modif d'itineraire
	public static Etape valueOf(String id_etape) {
		Etape e = new Etape();
		e.setId(Integer.valueOf(id_etape));
		return e;
	}

	@Override
	public String toString() {
		return "Etape [id=" + id + ", description=" + description + ", nom=" + nom + ", nbLike=" + nbLike
				+ ", etapeitineraires=" + etapeitineraires + "]";
	}
	

}