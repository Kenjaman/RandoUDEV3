package com.rando.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rando.dto.UtilisateurDto;
import com.rando.modele.Utilisateur;

@Repository
public class UtilisateurDao {
	
	@PersistenceContext
	private EntityManager em;

	public boolean existe(String nomUtilisateur) {
		long nb = em.createQuery("select count(u) from Utilisateur u where lower(.pseudo) = lower(:pseudo)", Long.class)
				.setParameter("nom", nomUtilisateur).getSingleResult();
		return nb > 0;
	}
	
	public void inscription(Utilisateur utilisateur) {
		em.persist(utilisateur);		
	}
	
	public Utilisateur getUtilisateur(int utilisateurId) {
		return em.find(Utilisateur.class, utilisateurId);
	}
	
	public List<Utilisateur> getAllUtilisateurs() {
		return em.createQuery("select u from Utilisateur u order by u.pseudo", Utilisateur.class).getResultList();
	}

	public void modifierUtilisateur(int utilisateurId, UtilisateurDto utilisateurDto) {
		em.createQuery(
				"update Utilisateur u set u.mdp=:mdp, u.pseudo=:pseudo, u.role=:role where u.id=:id")
				.setParameter("mdp", utilisateurDto.getMdp())
				.setParameter("pseudo", utilisateurDto.getPseudo())
				.setParameter("role", utilisateurDto.getRole())
				.setParameter("id", utilisateurId).executeUpdate();
	}
	
	public void supprimer(int utilisateurId) {	
		em.createQuery("delete from Utilisateur u where u.id = :id").setParameter("id", utilisateurId).executeUpdate();
	}

	public boolean getConnectUtilisateur(String pseudo, String mdp) {
		boolean verdict = false;
		if (pseudo != null && pseudo.trim().length() != 0 && mdp != null && mdp.trim().length() != 0) {
			long nb = em.createQuery("SELECT count(u) FROM Utilisateur u where u.pseudo = :login and u.mdp = :mdp",
					Long.class).setParameter("login", pseudo).setParameter("mdp", mdp).getSingleResult();
//			System.out.println("nb = " + nb);
			if (nb > 0 && nb == 1) {
				verdict = true;
			} else {
				verdict = false;
			}
		} else {
			verdict = false;
		}
		return verdict;
	}
}
