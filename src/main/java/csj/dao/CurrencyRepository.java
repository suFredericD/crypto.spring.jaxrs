package csj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csj.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
}