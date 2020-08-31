package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.modele.Iteneraire;

@Repository
public class ItineraireDao {

	@PersistenceContext
	private EntityManager em;
	
	public Iteneraire getIteneraire(int iteneraireId) {
		return em.find(Iteneraire.class, iteneraireId);
	}
	
	public List<Iteneraire> getAllIteneraires() {
		return em.createQuery("select i from Iteneraire i order by i.nom", Iteneraire.class).getResultList();
	}

	public boolean existe(String nomIteneraire) {
		long nb = em.createQuery("select count(i) from Iteneraire i where lower(i.nom) = lower(:nom)", Long.class)
				.setParameter("nom", nomIteneraire).getSingleResult();
		return nb > 0;
	}
	
	public void supprimer(String nomIteneraire) {	
		em.createQuery("delete from Iteneraire i where i.nom = :nom").setParameter("nom", nomIteneraire).executeUpdate();
	}
}
