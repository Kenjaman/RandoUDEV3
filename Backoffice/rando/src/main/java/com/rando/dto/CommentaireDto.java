package com.rando.dto;

import com.rando.modele.Etape;

public class CommentaireDto {

	private Integer id;
	private String com;
	private Etape etape;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the com
	 */
	public String getCom() {
		return com;
	}

	/**
	 * @param com the com to set
	 */
	public void setCom(String com) {
		this.com = com;
	}

	/**
	 * @return the etape
	 */
	public Etape getEtape() {
		return etape;
	}

	/**
	 * @param etape the etape to set
	 */
	public void setEtape(Etape etape) {
		this.etape = etape;
	}
}
