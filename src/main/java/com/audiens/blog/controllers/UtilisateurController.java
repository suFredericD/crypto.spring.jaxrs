package com.audiens.blog.controllers;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Response index() {
		logger.debug("utilisateur.index:");
		return Response.status(200).entity(blogDao.findAllUtilisateur()).build();
	}
	
	
	//  le premier \  -> caractère escape
	//             \d -> un caractère numérique  0...9
	//             +  -> multiplicateur 1 ou n fois ce qu'il y a devant 
	@RequestMapping(path="/{id:[0-9]+}", method = RequestMethod.GET)
	public Response findById(@PathVariable("id") String id) {
		logger.debug("utilisateur.findById:"+id);
		Utilisateur utilisateur = blogDao.getUtilisateur(Long.valueOf(id));
		if (utilisateur == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(utilisateur).build();
	}
	
	//@RequestMapping(path="/{email: [A-z]+.[A-z]+@[A-z]+.[A-z]+}", method = RequestMethod.GET)
	@RequestMapping(path="/{email:[A-z0-9]+.[A-z0-9]+@[A-z0-9]+.[A-z0-9]+}", method = RequestMethod.GET)
	public Response findByEmail(@PathVariable("email") String email) {
		logger.debug("utilisateur.findByEmail:"+email);
		Utilisateur utilisateur = blogDao.getUtilisateur(email);
		if (utilisateur == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(utilisateur).build();
	}

	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Utilisateur
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.POST)
	public Response add( @RequestBody Utilisateur utilisateur) {
		
		logger.debug("utilisateur.add:"+utilisateur.toString());
		String message="";
		try {
		  Long newid = blogDao.add(utilisateur);
		  return Response.status(201).entity(utilisateur).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Utilisateur
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.PUT)
	public Response update( @RequestBody Utilisateur utilisateur) {
		
		logger.debug("utilisateur.update:"+utilisateur.toString());
		String message="";
		try {
		  blogDao.update(utilisateur);
		  return Response.status(201).entity(utilisateur).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Utilisateur
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.DELETE)
	public Response delete( @RequestBody Utilisateur utilisateur) {
		
		logger.debug("utilisateur.update:"+utilisateur.toString());
		String message="";
		try {
		  blogDao.del(utilisateur);
		  return Response.status(201).entity(utilisateur).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
}
