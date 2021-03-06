package csj.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csj.model.Currency;
import csj.model.CurrencyType;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
	public List<Currency> findByCurrencyType(Optional<CurrencyType> currencyType);
	
}