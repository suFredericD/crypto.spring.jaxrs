package com.audiens.blog.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.audiens.blog.dao.BlogDao;
import com.audiens.blog.model.Utilisateur;


@RestController
// Ressource principale
// L'url qui amène à cette classe <contextApplcation>/utilisateur.....
@RequestMapping(path={"/utilisateur","/utilisateurs"})
public class UtilisateurController {
	private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);
	
	// On injecte le Bean BlogDao
	@Autowired BlogDao blogDao;
	
	// Sous ressource
	// L'url qui amène à cette classe <contextApplcation>/utilisateurs
	@RequestMapping(path="", method = RequestMethod.GET)
	public List<Utilisateur> index() {
		return blogDao.findAllUtilisateur();
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public Utilisateur findById(@PathVariable("id") String id) {
		
		return blogDao.getUtilisateur(Long.valueOf(id));
	}
}
