package com.univ.demo.Entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.univ.demo.Entity.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

	
	List<Etudiant> findByNom(String nom);
}
