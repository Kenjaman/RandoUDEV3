package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.modele.Utilisateur;

@Repository
public class UtilisateurDao {
	@PersistenceContext
	private EntityManager em;
	
	public Utilisateur getUtilisateur(int utilisateurId) {
		return em.find(Utilisateur.class, utilisateurId);
	}
	
	public List<Utilisateur> getAllUtilisateurs() {
		return em.createQuery("select u from Utilisateur u order by u.pseudo", Utilisateur.class).getResultList();
	}

	public boolean existe(String nomUtilisateur) {
		long nb = em.createQuery("select count(u) from Utilisateur u where lower(i.pseudo) = lower(:pseudo)", Long.class)
				.setParameter("nom", nomUtilisateur).getSingleResult();
		return nb > 0;
	}
	
	public void supprimer(String nomUtilisateur) {	
		em.createQuery("delete from Utilisateur u where u.pseudo = :pseudo").setParameter("pseudo", nomUtilisateur).executeUpdate();
	}
}
