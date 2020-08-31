package com.rando.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private int id;

	private String description;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	@Column(name="nb_like")
	private int nbLike;

	@Column(name="qr_code")
	private String qrCode;

	//bi-directional many-to-one association to Etapeitineraire
	@OneToMany(mappedBy="etape")
	private List<Etapeitineraire> etapeitineraires;

	public Etape() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbLike() {
		return this.nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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

}