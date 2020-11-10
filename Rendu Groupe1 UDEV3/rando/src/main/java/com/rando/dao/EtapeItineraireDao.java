package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.modele.Etapeitineraire;

@Repository
public class EtapeItineraireDao {

	@PersistenceContext
	private EntityManager em;

	public List<Etapeitineraire> getAllEtapeItineraireByIdItineraire(int itineraireId) {
		return em.createQuery("select ei from Etapeitineraire ei where ei.itineraire.id=:id", Etapeitineraire.class)
				.setParameter("id", itineraireId).getResultList();

	}
}
