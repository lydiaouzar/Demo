package com.univ.demo.Entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Etudiant {

	
	 private Long id;
	 private String nom;
	 
	 
	
	 
	 
	//constructor
	public Etudiant() {
		super();
		}
	 
	public Etudiant( String nom) {
		super();
		this.nom = nom;
	}
	
	 //Getter & Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	private List<Emprunt> emprunts= new ArrayList<Emprunt>();
	
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="emprunteur", fetch = FetchType.EAGER)
	public List<Emprunt> getEmprunts(){ 
		 return emprunts;
	 }
	 
	public void setEmprunts(List<Emprunt> emprunts){ 
		 this.emprunts = emprunts;
	 }
	 
	 public void addEmprunt( Emprunt emprunt ){ 
		 emprunts= new ArrayList<Emprunt>();
		 emprunts.add(emprunt);
	     }
	 

	
	 @Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", emprunts=" + emprunts + "]";
	}

	public int nbEmprunts (){
			return emprunts.size();
		}
	 
	 
}
