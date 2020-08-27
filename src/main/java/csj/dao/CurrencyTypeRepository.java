package csj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csj.model.Currency;
import csj.model.CurrencyType;

@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Integer> {
	
	
	
}