package com.univ.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class Livre {
	
 
 @Id @GeneratedValue private Long numero;
 protected String iSBN;
 protected String noml;
 

	@OneToMany(cascade=CascadeType.ALL, mappedBy="livreEmprunte", fetch = FetchType.EAGER)
	 private List<Emprunt> emprunts;

 
	
 public String getNoml() {
		return noml;
	}


	public void setNoml(String noml) {
		this.noml = noml;
	}


//constructor
 public Livre() {
		
	}
 
 
 public Livre( String iSBN, String noml) {
	super();
	
	this.iSBN = iSBN;
	this.noml=noml;
	
}


//Getter & Setter

public String getISBN() {
	return iSBN;
}
public void setISBN(String iSBN) {
	this.iSBN = iSBN;
}
 
@JsonIgnore
public List<Emprunt> getEmprunts(){ 
	 return emprunts;
}

public void setEmprunts(List<Emprunt> emprunts){ 
	 this.emprunts = emprunts;
}

public void addEmprunt( Emprunt emprunt ){ 
	 emprunts.add(emprunt);
	// this. getRents().add( rent );
   // rent.personne = this; 
    }



@Override
public String toString() {
	return "Livre [numero=" + numero + ", iSBN=" + iSBN + "]";
}


public int nbEmrunts (){
		return emprunts.size();
	}
 
 
 
}
