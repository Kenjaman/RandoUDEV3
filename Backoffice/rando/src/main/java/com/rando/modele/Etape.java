package com.rando.modele;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.persistence.*;
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

	private Integer latitude;

	private Integer longitude;

	private String nom;

	@Column(name="nb_like")
	private Integer nbLike;

	@Column(name="qr_code")
	private BufferedImage qrCode;

	//bi-directional many-to-one association to Etapeitineraire
	@OneToMany(mappedBy="etape")
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

	public Integer getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public Integer getNbLike() {
		return this.nbLike;
	}

	public void setNbLike(Integer nbLike) {
		this.nbLike = nbLike;
	}

	public BufferedImage getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(BufferedImage bufferedImage) {
		this.qrCode = bufferedImage;
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