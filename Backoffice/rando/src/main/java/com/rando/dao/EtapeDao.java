package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.modele.Etape;

@Repository
public class EtapeDao {

	@PersistenceContext
	private EntityManager em;
	

	
	public Etape getIteneraire(int etapeId) {
		return em.find(Etape.class, etapeId);
	}
	
	public List<Etape> getAllEtapes() {
		return em.createQuery("select e from Etape i order by e.name", Etape.class).getResultList();
	}

	public boolean existe(String nomEtape) {
		long nb = em.createQuery("select count(i) from Etape e where lower(e.name) = lower(:name)", Long.class)
				.setParameter("name", nomEtape).getSingleResult();
		return nb > 0;
	}
	
	public void supprimer(String nomEtape) {	
		em.createQuery("delete from Etape e where e.name = :name").setParameter("name", nomEtape).executeUpdate();
	}
}
