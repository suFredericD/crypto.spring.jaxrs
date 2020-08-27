package com.audiens.blog.controllers;

import java.sql.Timestamp;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.audiens.blog.dao.BlogDao;
import com.audiens.blog.model.Article;
import com.audiens.blog.model.Utilisateur;

@RestController
@CrossOrigin
//Ressource principale
//L'url qui amène à cette classe <contextApplcation>/utilisateur.....
@RequestMapping(path={"/utilisateur","/utilisateurs"})
public class UtilisateurController {
	private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);
	
	// On injecte le Bean BlogDao
	@Autowired BlogDao blogDao;
	
	// Sous ressource
	// L'url qui amène à cette classe <contextApplcation>/utilisateurs
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.GET)
	public Response index() {
		logger.debug("utilisateur.index:");
		return Response.status(200).entity(blogDao.findAllUtilisateur()).build();
	}
	
	
	//  le premier \  -> caractère escape
	//             \d -> un caractère numérique  0...9
	//             +  -> multiplicateur 1 ou n fois ce qu'il y a devant 
	//@RequestMapping(path="/{id:\\d+}", method = RequestMethod.GET)
	@CrossOrigin
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
	// [A-z0-9] --> représente un caractère pris dans l'ensemble ABC...YZabc...yz0123...89
	// +  -> multiplicateur 1 ou n fois ce qu'il y a devant  
	// aaa11.bb22@ccc33.ddd44 --> correspond !
	// aaa11.bb22.eee555@ccc33.ddd44 --> ne correspond pas !
	// aaa11bb22@ccc33.ddd44
	// ?  --> multiplicateur 0 ou 1
	//@RequestMapping(path="/{email:[A-z0-9]+.[A-z0-9]+@[A-z0-9]+.[A-z0-9]{2,6}}", method = RequestMethod.GET)
	// {1,3}  --> multiplicateur : 0, 1 ,2 ou 3
	@CrossOrigin
	@RequestMapping(path="/{email:(?:[A-z0-9]+.){0,3}[A-z0-9]+@[A-z0-9]+.[A-z0-9]{2,6}}", method = RequestMethod.GET)
	public Response findByEmail(@PathVariable("email") String email) {
		logger.debug("utilisateur.findByEmail:"+email);
		Utilisateur utilisateur = blogDao.getUtilisateur(email);
		if (utilisateur == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(utilisateur).build();
	}
	
	@CrossOrigin
	@RequestMapping(path="/byarticle/{idarticle}", method = RequestMethod.GET)
	public Response findByArticle(@PathVariable("idarticle") String idarticle) {
		Article article = blogDao.getArticle(Long.valueOf(idarticle));
		Utilisateur utilisateur = blogDao.getUtilisateur(article);
		if (utilisateur == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(utilisateur).build();
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Utilisateur
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode POST.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.POST)
	public Response add( @RequestBody Utilisateur utilisateur) {
		
		Timestamp tmp = new Timestamp(System.currentTimeMillis());
		utilisateur.setCreele(tmp);
		logger.debug("utilisateur.add:" + utilisateur.toString());
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
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode PUT.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.PUT)
	public Response update( @RequestBody Utilisateur utilisateur) {
		
		logger.debug("utilisateur.update:" + utilisateur.toString());
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
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/utilisateur  avec la méthode DELETE.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.DELETE)
	public Response delete( @RequestBody Utilisateur utilisateur) {
		
		logger.debug("utilisateur.delete:" + utilisateur.toString());
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
