package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;


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
	private Integer id;

	@Column(name="num_etape")
	private Integer numEtape;

	//bi-directional many-to-one association to Etape
	@ManyToOne
	@JoinColumn(name="id_etape")
	private Etape etape;

	//bi-directional many-to-one association to Itineraire
	@ManyToOne
	@JoinColumn(name="id_itineraire")
	@JsonIgnore
	private Itineraire itineraire;

	public Etapeitineraire() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumEtape() {
		return this.numEtape;
	}

	public void setNumEtape(Integer numEtape) {
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