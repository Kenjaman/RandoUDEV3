package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.dto.ItineraireDto;
import com.rando.modele.Etapeitineraire;
import com.rando.modele.Itineraire;

@Repository
public class ItineraireDao {

	@PersistenceContext
	private EntityManager em;

	public boolean existe(String nomIteneraire) {
		long nb = em.createQuery("select count(i) from Itineraire i where lower(i.nom) = lower(:nom)", Long.class)
				.setParameter("nom", nomIteneraire).getSingleResult();
		return nb > 0;
	}
	
	public int ajouterItineraire(Itineraire itineraire) {
		em.persist(itineraire);
		return itineraire.getId();
	}


	public Itineraire getIteneraire(int itineraireId) {
		return em.find(Itineraire.class, itineraireId);
	}

	public List<Itineraire> getAllIteneraires() {
		return em.createQuery("select i from Itineraire i order by i.id desc", Itineraire.class).getResultList();
	}

	public void modifierItineraire(Integer itineraireId, ItineraireDto itineraireDto) {
		em.createQuery("update Itineraire i set i.nom=:nom, i.niveau=:niveau where i.id=:id")
				.setParameter("nom", itineraireDto.getNom()).setParameter("niveau", itineraireDto.getNiveau())
				.setParameter("id", itineraireId).executeUpdate();
	}

	public void supprimerItineraire(int itineraireId) {
		em.createQuery("delete from Itineraire i where i.id = :id").setParameter("id", itineraireId).executeUpdate();
	}
}
