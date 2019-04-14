package com.univ.demo.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Article extends Livre {
	
	
	
	
protected int anneeEdition ;
protected int prix;


//constructor
public Article() {
		
	}


public Article( int anneeEdition, String iSBN, int prix) {
	super();
	this.anneeEdition = anneeEdition;
	this.prix = prix;
}



//Getter & Setter

public int getAnneeEdition() {
	return anneeEdition;
}
public void setAnneeEdition(int anneeEdition) {
	this.anneeEdition = anneeEdition;
}


public int getPrice() {
	return prix;
}

public void setPrice(int prix) {
	this.prix = prix;
}




}
