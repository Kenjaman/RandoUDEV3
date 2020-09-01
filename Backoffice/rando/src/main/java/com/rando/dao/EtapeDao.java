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
		long nb = em.createQuery("select count(i) from Etape e where lower(e.name) = lower(:name)", Long.class)
				.setParameter("name", nomEtape).getSingleResult();
		return nb > 0;
	}

	public Etape getIteneraire(int etapeId) {
		return em.find(Etape.class, etapeId);
	}

	public List<Etape> getAllEtapes() {
		return em.createQuery("select e from Etape i order by e.name", Etape.class).getResultList();
	}

	public void modifierEtape(int etapeId, EtapeDto etapeDto) {
		em.createQuery(
				"update Etape e set e.description=:description, e.latitude=:latitude, e.longitude=:longitude, e.name=:name,e.qrcode=:qrcode where u.id=:id")
				.setParameter("description", etapeDto.getDescription()).setParameter("latitude", etapeDto.getLatitude())
				.setParameter("longitude", etapeDto.getLongitude()).setParameter("name", etapeDto.getName())
				.setParameter("qrcode", etapeDto.getQrCode()).setParameter("id", etapeId).executeUpdate();
	}

	public void supprimer(int etapeId) {
		em.createQuery("delete from Etape e where e.id = :id").setParameter("id", etapeId).executeUpdate();
	}
}
