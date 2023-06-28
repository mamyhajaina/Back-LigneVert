package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "volet")
public class Volet{
	
	 
	@Column(name = "idVolet" )
	private int idVolet;
	 
	@Column(name = "nomVolet" )
	private String nomVolet;

	@Column(name = "idProjet" )
	private int idProjet;

	public int getIdVolet() {
		return idVolet;
	}

	public void setIdVolet(int idVolet) {
		this.idVolet = idVolet;
	}

	public String getNomVolet() {
		return nomVolet;
	}

	public void setNomVolet(String nomVolet) {
		this.nomVolet = nomVolet;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	
	
	

	
}
