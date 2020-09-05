package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.dto.EtapeDto;
import com.rando.modele.Etape;

@Repository
public class EtapeDao {

	@PersistenceContext
	private EntityManager em;

	public boolean existe(String nomEtape) {
		long nb = em.createQuery("select count(e) from Etape e where lower(e.nom) = lower(:nom)", Long.class)
				.setParameter("nom", nomEtape).getSingleResult();
		return nb > 0;
	}

	public Etape getEtape(int etapeId) {
		return em.find(Etape.class, etapeId);
	}

	public Etape getEtapeByNom(String etapeNom) {
		return em.createQuery("select e from Etape e where lower(e.nom) = lower(:nom)", Etape.class)
		.setParameter("nom", etapeNom).getSingleResult();
	}
	
	public List<Etape> getAllEtapes() {
		return em.createQuery("select e from Etape e order by e.nom", Etape.class).getResultList();
	}
	
	
	public List<Etape> getEtapesItineraire(Integer id_iti){
		return em.createQuery("select e from Etape e join EtapeItineraire ei on e.id=ei.id_etape where ei.id_itineraire = :id_iti order by num_etape", Etape.class).getResultList();
	}
	
	public int ajouterEtape(Etape etape) {
		em.persist(etape);
		return etape.getId();
	}
	
	public void modifierEtape(int etapeId, EtapeDto etapeDto) {
		em.createQuery(
				"update Etape e set e.description=:description, e.nom=:nom where e.id=:id")
				.setParameter("description", etapeDto.getDescription()).setParameter("nom", etapeDto.getNom())
				.setParameter("id", etapeId).executeUpdate();
	}

	public void supprimer(int etapeId) {
		em.createQuery("delete from Etape e where e.id = :id").setParameter("id", etapeId).executeUpdate();
	}
	
	public int getNbItinerairesEtape(int etapeId){
		return em.createQuery("select count(ei) from Etape e join EtapeItineraire ei on e.id=ei.id_etape where e.id=:id",Integer.class).setParameter("id", etapeId).getSingleResult();
	}
}
