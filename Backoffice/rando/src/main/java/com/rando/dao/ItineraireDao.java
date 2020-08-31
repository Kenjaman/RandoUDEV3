package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.modele.Itineraire;

@Repository
public class ItineraireDao {

	@PersistenceContext
	private EntityManager em;
	
	public Itineraire getIteneraire(int itineraireId) {
		return em.find(Itineraire.class, itineraireId);
	}
	
	public List<Itineraire> getAllIteneraires() {
		return em.createQuery("select i from Iteneraire i order by i.nom", Itineraire.class).getResultList();
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
