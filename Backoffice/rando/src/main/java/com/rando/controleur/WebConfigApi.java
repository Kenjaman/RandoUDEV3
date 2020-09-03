package com.rando.controleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rando.modele.Utilisateur;

@RestController
@RequestMapping("/api")
public class WebConfigApi {

    @GetMapping(path="/user", produces= "application/json")
    public Utilisateur getUser() {
    	Utilisateur item = new Utilisateur();
        item.setPseudo("XV-32");
        item.setMdp("Weird stuff");
        item.setRole("admin");
        return item;
    }
}
