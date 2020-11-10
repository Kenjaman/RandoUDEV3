package com.rando.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rando.dao.UtilisateurDao;
import com.rando.dto.UtilisateurDto;
import com.rando.modele.Utilisateur;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	public boolean getConnectUser(String login, String mdp) {
		return utilisateurDao.getConnectUtilisateur(login, mdp);
	}

	@Transactional
	public void inscription(UtilisateurDto utilisateurDto) throws AfficheMessageException{
		if (!utilisateurDao.existe(utilisateurDto.getPseudo())) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo(utilisateurDto.getPseudo());
			utilisateur.setMdp(utilisateurDto.getMdp());
			utilisateur.setRole("admin");
			utilisateurDao.inscription(utilisateur);
		} else {
			throw new AfficheMessageException("Cet utilisateur existe deja");
		}
		
	}

	public List<Utilisateur> getAllUsers() {
		return utilisateurDao.getAllUtilisateurs();
	}
}
