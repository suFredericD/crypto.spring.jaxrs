package csj.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import csj.model.*;

@Component
public class CryptoDaoImpl implements CryptoDao {
	
	@Autowired PeopleRepository peopleRep;
	@Autowired CurrencyRepository currencyRep;
	@Autowired CurrencyTypeRepository currencyTypeRep;

// ---------------------------------------------------------------------------------------
//		LES PERSONNES
// ---------------------------------------------------------------------------------------	
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

// ---------------------------------------------------------------------------------------
//	LES MONNAIES
//---------------------------------------------------------------------------------------
	@Override
	public List<Currency> findAllCurrencies() {
		return currencyRep.findAll();
	}

	@Override
	public Currency getCurrency(Long id) {
		Optional<Currency> currency = currencyRep.findById(id);
		if(currency.isPresent())
	   	   return currency.get();
		else
			return null;
	}
	
	@Override
	public List<Currency> getCurrenciesByType(Long id) {
		Optional<CurrencyType> currencyType = currencyTypeRep.findById(Integer.valueOf(id.toString()));
		return currencyRep.findByCurrencyType(currencyType);
		
	}

// ---------------------------------------------------------------------------------------
//		LES TYPES DE MONNAIES
//---------------------------------------------------------------------------------------
	public CurrencyType getCurrencyType(Long id) {
		Optional<CurrencyType> currencyType = currencyTypeRep.findById(Integer.valueOf(id.toString()));
		if(currencyType.isPresent())
	   	   return currencyType.get();
		else
			return null;
	}
}