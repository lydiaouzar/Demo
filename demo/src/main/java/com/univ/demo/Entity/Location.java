package com.univ.demo.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Location extends Livre {
	
	@Id @GeneratedValue 
	private Long numero;
	private int nbPage;
	protected int prix;
	
	
	
	//constructor
	public Location() {
		super();	
		}
	
	 public Location(int nbPage, int prix, List<Emprunt> emprunts) {
		super();
		this.nbPage = nbPage;
		this.prix = prix;
	}



	//Getter & Setter
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public int getNbPage() {
		return nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	
	

}
