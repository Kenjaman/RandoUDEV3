package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the etapeitineraire database table.
 * 
 */
@Entity
@NamedQuery(name="Etapeitineraire.findAll", query="SELECT e FROM Etapeitineraire e")
public class Etapeitineraire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="num_etape")
	private int numEtape;

	//bi-directional many-to-one association to Etape
	@ManyToOne
	@JoinColumn(name="id_etape")
	private Etape etape;

	//bi-directional many-to-one association to Itineraire
	@ManyToOne
	@JoinColumn(name="id_itineraire")
	private Itineraire itineraire;

	public Etapeitineraire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumEtape() {
		return this.numEtape;
	}

	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}

	public Etape getEtape() {
		return this.etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public Itineraire getItineraire() {
		return this.itineraire;
	}

	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}

}