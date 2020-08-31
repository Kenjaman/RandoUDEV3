package com.rando.dto;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import com.rando.modele.Etapeitineraire;

public class EtapeDto {
	private int id;
	@NotBlank(message = "Vous devez fournir une description !")
	private String description;
	@NotBlank(message = "Vous devez indiquer une latitude !")
	private BigDecimal latitude;
	@NotBlank(message = "Vous devez indiquer une longitude !")
	private BigDecimal longitude;
	@NotBlank(message = "Vous devez donner un nom à cette étape !")
	private String name;
	private String qrCode;
	private List<Etapeitineraire> etapeitineraires;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the latitude
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}
	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
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
	
}
