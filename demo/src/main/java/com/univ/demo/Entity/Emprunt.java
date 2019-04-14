package com.univ.demo.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Emprunt {
	
@Id @GeneratedValue private Long numero;
 private Date beginEmprunt ;
 private Date endemprunt;
 
 @ManyToOne(cascade=CascadeType.ALL)
 private Etudiant emprunteur;
 
 @ManyToOne(cascade=CascadeType.ALL)
 private Livre livreEmprunte;
 
 
	//constructor
	public Emprunt() {
		super();
		}
	 
	public Emprunt( Date beginEmprunt, Date endemprunt) {
		super();
		
		this.beginEmprunt = beginEmprunt;
		this.endemprunt = endemprunt;
	}




//Getter & Setter
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}
public Date getBeginEmprunt() {
	return beginEmprunt;
}
public void setBeginEmprunt(Date beginEmprunt) {
	this.beginEmprunt = beginEmprunt;
}
public Date getEndemprunt() {
	return endemprunt;
}
public void setEndemprunt(Date endemprunt) {
	this.endemprunt = endemprunt;
}


public Etudiant getEmprunteur() {
	return emprunteur;
}

public void setEmprunteur(Etudiant emprunteur) {
	this.emprunteur = emprunteur;
}

public Livre getLvrEmprunte() {
	return livreEmprunte;
}

public void setLvrEmprunte(Livre livre) {
	this.livreEmprunte = livre;
}

@Override
public String toString() {
	return "Emprunt [numero=" + numero + ", beginEmprunt=" + beginEmprunt + ", endemprunt=" + endemprunt + ", livreEmprunte="
			+ livreEmprunte + "]";
}


}
