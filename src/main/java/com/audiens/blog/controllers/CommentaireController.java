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
import com.audiens.blog.model.Commentaire;


@RestController
// Ressource principale
// L'url qui amène à cette classe <contextApplcation>/commentaire.....
@RequestMapping(path={"/commentaire","/commentaires"})
public class CommentaireController {
	private static final Logger logger = LoggerFactory.getLogger(CommentaireController.class);
	
	// On injecte le Bean BlogDao
	@Autowired BlogDao blogDao;
	
//	// Sous ressource
//	// L'url qui amène à cette classe <contextApplcation>/commentaires
//	@RequestMapping(path="", method = RequestMethod.GET)
//	public Response index() {
//		return Response.status(200).entity(blogDao.findAllCommentaire()).build();
//	}
	
//	@RequestMapping(path="/{id}", method = RequestMethod.GET)
//	public Response findById(@PathVariable("id") String id) {
//		Commentaire commentaire = blogDao.getCommentaire(Long.valueOf(id));
//		if (commentaire == null) {
//			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
//			return Response.status(404).build();
//		}
//		return Response.status(200).entity(commentaire).build();
//	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Commentaire
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/commentaire  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.POST)
	public Response add( @RequestBody Commentaire commentaire) {
		
		logger.debug("commentaire.add:"+commentaire.toString());
		String message="";
		try {
		  Long newid = blogDao.add(commentaire);
		  return Response.status(201).entity(commentaire).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Commentaire
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/commentaire  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.PUT)
	public Response update( @RequestBody Commentaire commentaire) {
		
		logger.debug("commentaire.update:"+commentaire.toString());
		String message="";
		try {
		  blogDao.update(commentaire);
		  return Response.status(201).entity(commentaire).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Commentaire
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/commentaire  avec la méthode POST.
	@RequestMapping(path="", method = RequestMethod.DELETE)
	public Response delete( @RequestBody Commentaire commentaire) {
		
		logger.debug("commentaire.update:"+commentaire.toString());
		String message="";
		try {
		  blogDao.del(commentaire);
		  return Response.status(201).entity(commentaire).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
}
