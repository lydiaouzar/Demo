package com.univ.demo.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Dictionnaire extends Livre {
	

	
	private int nbPage;
	protected int prix;
	private boolean emprunt;
	
	
	
	//constructor
	public Dictionnaire() {
		super();	
		}
	
	 public Dictionnaire(int nbPage,String iSBN, int prix, String noml) {
		super(iSBN,noml);
		this.nbPage = nbPage;
		this.prix = prix;
	}



	//Getter & Setter

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

	


	
	@Override
	public String toString() {
		return "Dictinnaire [nbPage=" + nbPage + ", prix=" + prix + ", iSBN=" + iSBN + ", noml="
				+ noml + "]";
	}

	public boolean isEmprunt() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setEmprunt(boolean emprunt) {
		this.emprunt = emprunt;
	}
	
	
	

}
