package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "volet")
public class Volet{
	
	 
	@Column(name = "idvolet" )
	private int idvolet;
	 
	@Column(name = "nomVolet" )
	private String nomProjet;

	@Column(name = "idProjet" )
	private int idProjet;

	public int getIdvolet() {
		return idvolet;
	}

	public void setIdvolet(int idvolet) {
		this.idvolet = idvolet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	
	

	
}
