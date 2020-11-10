package com.rando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.EtapeDao;
import com.rando.dto.EtapeDto;
import com.rando.modele.Etape;

@Service
public class EtapeService {

	@Autowired
	EtapeDao etapeDao;

	/**
	 * Récupérer toutes les étapes
	 * 
	 * @return Une collection de toutes les étapes de la base de données
	 */
	public List<Etape> getAllEtapes() {
		return etapeDao.getAllEtapes();
	}

	/**
	 * Récupérer une étape par son id
	 * 
	 * @param etapeId
	 * @return une instance d'Etape correspondante a l'étape possèdant l'id  etapeId présente dans la base de données
	 */
	public Etape getEtape(int etapeId) {
		return etapeDao.getEtape(etapeId);
	}

	/**
	 * Envoie de l'étape etapeDto en provenance de la vue dans la couche d'accès aux données pour insert.
	 * 
	 * La méthode est transcationnelle, l'integrités des données de la base sera préserver en cas d'echec de la transaction
	 * Peut renvoyer l'exception {@link EtapeExisteDejaException} si le nom de {@link EtapeDto} est pris par une étape
	 * @param etapeDto
	 * @return Renvoie le nombre de ligne ajouté par la requète
	 * @throws EtapeExisteDejaException
	 */
	@Transactional
	public int ajouter(EtapeDto etapeDto) throws EtapeExisteDejaException {
		if(etapeDto != null) {
			if(etapeDao.existe(etapeDto.getNom()))
				throw new EtapeExisteDejaException("L'étape existe déjà");
			Etape nEtape = new Etape();
			nEtape.setNom(etapeDto.getNom());
			nEtape.setDescription(etapeDto.getDescription());
			nEtape.setNbLike(0);
			return etapeDao.ajouterEtape(nEtape);
		}
		return 0;
	}

	
	/**
	 * Envoie d'un ordre de modification a la bdd de l'étape id = etapeId avec les attribut présents dans {@link EtapeDto}
	 * 
	 * La méthode est transcationnelle, l'integrités des données de la base sera préserver en cas d'echec de la transaction
	 * Peut renvoyer l'exception {@link EtapeExisteDejaException} si le nom de {@link EtapeDto} est pris par une étape
	 * @param etapeId
	 * @param etapeDto
	 * @throws EtapeExisteDejaException
	 */
	@Transactional
	public void modifier(int etapeId,EtapeDto etapeDto) throws EtapeExisteDejaException {
		if(etapeDto != null) {
			if(etapeDao.existe(etapeDto.getNom()))
				throw new EtapeExisteDejaException("L'étape existe déjà");
			etapeDao.modifierEtape(etapeId, etapeDto);
		}
	}
	
	
	/**
	 * Envoie d'un ordre de suppression a la bdd de l'étape id
	 * 
	 * La méthode est transcationnelle, l'integrités des données de la base sera préserver en cas d'echec de la transaction
	 * Peut renvoyer l'exception {@link EtapeEncoreDansUnItineraireException} si l'étape est encore référencée dans un itineraire dans ce cas là,
	 * la méthode effectue un rollback.
	 * @param id
	 * @throws EtapeEncoreDansUnItineraireException
	 */
	@Transactional(rollbackFor = EtapeEncoreDansUnItineraireException.class)
	public void supprimer(int id) throws EtapeEncoreDansUnItineraireException{
		Etape etape = etapeDao.getEtape(id);
		if(etape == null)
			return;
		if(!etape.getEtapeitineraires().isEmpty())
			throw new EtapeEncoreDansUnItineraireException("L'étape que vous tentez de supprimer est comprise dans un itineraire veuillez le supprimer d'abord");
		etapeDao.supprimer(id);
	}

	
	/*
	 * Traitement des actions API:
	 * likerEtape et dislikeEtape renvoient le nombre de like de l'étape une fois mise a jour
	 * 
	 */
	
	/**
	 * Envoie d'un ordre de modification a la bdd de l'étape ayant les attributs de {@link EtapeDto} 
	 * afin d'incrémenter son nombre de likes nb_like
	 * 
	 * La méthode est transcationnelle, l'integrités des données de la base sera préserver en cas d'echec de la transaction
	 * 
	 * @param etapeDto
	 */
	@Transactional
	public EtapeDto likeEtape(EtapeDto etapeDto) {
//		System.out.println("lik "+etapeDto);
//		System.out.println(etapeDto.getNbLike());
		etapeDto.setNbLike(etapeDto.getNbLike()+1);
		etapeDao.actionEtape(etapeDto);
		return etapeDto;
	}

	/**
	 * Envoie d'un ordre de modification a la bdd de l'étape ayant les attributs de {@link EtapeDto} 
	 * afin de décrémenter son nombre de likes nb_like
	 * 
	 * La méthode est transcationnelle, l'integrités des données de la base sera préserver en cas d'echec de la transaction
	 * 
	 * @param etapeDto
	 */
	@Transactional
	public EtapeDto dislikeEtape(EtapeDto etapeDto) {
		etapeDto.setNbLike(etapeDto.getNbLike()-1);
		etapeDao.actionEtape(etapeDto);
		return etapeDto;
	}
	
}
