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



	public List<Etape> getAllEtapes() {
		return etapeDao.getAllEtapes();
	}

	public Etape getEtape(int etapeId) {
		return etapeDao.getEtape(etapeId);
	}

	@Transactional
	public int ajouter(EtapeDto etapeDto) throws EtapeExisteDejaException {
		if(etapeDto != null) {
			if(etapeDao.existe(etapeDto.getNom()))
				throw new EtapeExisteDejaException("L'étape existe déjà");
			Etape nEtape = new Etape();
			nEtape.setNom(etapeDto.getNom());
			nEtape.setDescription(etapeDto.getDescription());
			return etapeDao.ajouterEtape(nEtape);
		}
		return 0;
	}

	@Transactional
	public void modifier(int etapeId,EtapeDto etapeDto) {
		etapeDao.modifierEtape(etapeId, etapeDto);
	}

	@Transactional(rollbackFor = EtapeEncoreDansUnItineraireException.class)
	public void supprimer(int id) throws EtapeEncoreDansUnItineraireException{
		Etape etape = etapeDao.getEtape(id);
		if(etape == null)
			return;
		if(!etape.getEtapeitineraires().isEmpty())
			throw new EtapeEncoreDansUnItineraireException("L'étape que vous tentez de supprimer est comprise dans un itineraire veuillez le supprimer d'abord");
		etapeDao.supprimer(id);
		// TODO Auto-generated method stub

	}

	
	/*
	 * likerEtape et dislikeEtape renvoient le nombre de like de l'étape une fois mise a jour
	 * 
	 */
	@Transactional
	public EtapeDto actionEtape(EtapeDto etapeDto,String action) {
		if(action.equalsIgnoreCase("like"))
			etapeDto.setNbLike(etapeDto.getNbLike()+1);
		else
			etapeDto.setNbLike(etapeDto.getNbLike()-1);
		etapeDao.actionEtape(etapeDto);
		return etapeDto;
	}

//	@Transactional
//	public EtapeDto dislikeEtape(Integer etapeId) {
//		Etape etape = etapeDao.getEtape(etapeId);
//		etape.setNbLike(etape.getNbLike()-1);
//		if(etapeDao.likeEtape(etape) > 0) {
//			return etape.getNbLike();
//		}
//		else
//			return -69;
//	}



}
