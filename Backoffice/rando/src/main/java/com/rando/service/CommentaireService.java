package com.rando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rando.dao.CommentaireDao;
import com.rando.dto.CommentaireDto;
import com.rando.modele.Commentaire;

@Service
public class CommentaireService {

	@Autowired
	private CommentaireDao commentaireDao;
	
	public void validezCommentaireSuEtape(CommentaireDto commentaireDto) throws AfficheMessageException{
		Commentaire commentaire=new Commentaire();
		commentaire.setCom(commentaireDto.getCom());
		commentaire.setEtape(commentaireDto.getEtape());
		commentaireDao.validezCommentaireSuEtape(commentaire);
	}
}
