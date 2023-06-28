package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "distrique")
public class Distrique{
	
	 
	@Column(name = "idDistrique" )
	private int idDistrique;
	 
	@Column(name = "nomDistrique" )
	private String nomDistrique;
	
	@Column(name = "idProjet" )
	private int idProjet;
	
	@Column(name = "commune" )
	private String commune;
	
	@Column(name = "fokotany" )
	private String fokotany;
	
	
	

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getFokotany() {
		return fokotany;
	}

	public void setFokotany(String fokotany) {
		this.fokotany = fokotany;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public int getIdDistrique() {
		return idDistrique;
	}

	public void setIdDistrique(int idDistrique) {
		this.idDistrique = idDistrique;
	}

	public String getNomDistrique() {
		return nomDistrique;
	}

	public void setNomDistrique(String nomDistrique) {
		this.nomDistrique = nomDistrique;
	}
	
	
	
}
