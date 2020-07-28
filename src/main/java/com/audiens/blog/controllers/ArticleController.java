package com.audiens.blog.controllers;

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


@RestController
// Ressource principale
// L'url qui amène à cette classe <contextApplcation>/article.....
@RequestMapping(path={"/article","/articles"})
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	// On injecte le Bean BlogDao
	@Autowired BlogDao blogDao;
	
	// Sous ressource
	// L'url qui amène à cette classe <contextApplcation>/articles
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.GET)
	public Response index() {
		return Response.status(200).entity(blogDao.findAllArticle()).build();
	}
	
	@CrossOrigin
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public Response findById(@PathVariable("id") String id) {
		Article article = blogDao.getArticle(Long.valueOf(id));
		if (article == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(article).build();
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Article
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/article  avec la méthode POST.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.POST)
	public Response add( @RequestBody Article article) {
		
		logger.debug("article.add:"+article.toString());
		String message="";
		try {
		  Long newid = blogDao.add(article);
		  return Response.status(201).entity(article).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Article
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/article  avec la méthode POST.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.PUT)
	public Response update( @RequestBody Article article) {
		
		logger.debug("article.update:"+article.toString());
		String message="";
		try {
		  blogDao.update(article);
		  return Response.status(201).entity(article).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
	// l'annotation @RequestBody permet d'injecter le body de la requete dans l'objet Article
	// Le mapping correspond à l'url http://localhost:8080/blog.spring.jaxrs/article  avec la méthode POST.
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.DELETE)
	public Response delete( @RequestBody Article article) {
		
		logger.debug("article.update:"+article.toString());
		String message="";
		try {
		  blogDao.del(article);
		  return Response.status(201).entity(article).build();
		}
		catch (Exception e) {
            message +=e.getMessage();
			return Response.status(530).entity(message).build(); 
		}
	}
	
}
