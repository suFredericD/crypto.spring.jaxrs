package csj.controllers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import csj.dao.*;
import csj.model.People;

@RestController
@CrossOrigin
//Ressource principale
//L'url qui amène à cette classe <contextApplcation>/utilisateur.....
@RequestMapping(path={"/people"})
public class PeopleController {
	
	// On injecte le Bean BlogDao
	@Autowired CryptoDao cryptoDao;
	
	// Sous ressource
	// L'url qui amène à cette classe <contextApplcation>/utilisateurs
	@CrossOrigin
	@RequestMapping(path="", method = RequestMethod.GET)
	public Response index() {
		return Response.status(200).entity(cryptoDao.findAllPeople()).build();
	}
	
	@CrossOrigin
	@RequestMapping(path="/{id:[0-9]+}", method = RequestMethod.GET)
	public Response findById(@PathVariable("id") String id) {
		People people = cryptoDao.getPeople(Long.valueOf(id));
		if (people == null) {
			// Si la couche dao retourne un objet vide, on retourne un code 404 = non trouvé
			return Response.status(404).build();
		}
		return Response.status(200).entity(people).build();
	}

	
}
