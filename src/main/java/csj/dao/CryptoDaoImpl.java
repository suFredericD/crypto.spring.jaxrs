package csj.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import csj.model.*;

@Component
public class CryptoDaoImpl implements CryptoDao {
	
	@Autowired PeopleRepository peopleRep;

	@Override
	public List<People> findAllPeople() {
		return peopleRep.findAll();
	}

	@Override
	public People getPeople(Long id) {
		Optional<People> people = peopleRep.findById(id);
		if(people.isPresent())
	   	   return people.get();
		else
			return null;
	}

}