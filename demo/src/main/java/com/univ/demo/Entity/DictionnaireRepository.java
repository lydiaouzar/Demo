package com.univ.demo.Entity;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface DictionnaireRepository extends CrudRepository<Dictionnaire, Long>{

	Dictionnaire findByISBN(String iSBN);
	//List<Person> findByNom(String nom);


}
