package com.rando.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rando.dto.CommentaireDto;
import com.rando.modele.Commentaire;

@Repository
public class CommentaireDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void validezCommentaireSuEtape(Commentaire commentaire) {
		em.persist(commentaire);
	}
}
