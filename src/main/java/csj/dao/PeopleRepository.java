package csj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csj.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
	
}