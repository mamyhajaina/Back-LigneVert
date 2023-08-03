package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "projet")
public class Projet{
	
	 
	@Column(name = "idProjet" )
	private int idProjet;
	 
	@Column(name = "nomProjet" )
	private String nomProjet;

	@Column(name = "details" )
	private String details;
	
	@Column(name = "powerAppId" )
	private String powerAppId;
	
	@Column(name = "couleur" )
	private String couleur;
	
	

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPowerAppId() {
		return powerAppId;
	}

	public void setPowerAppId(String powerAppId) {
		this.powerAppId = powerAppId;
	}

	
}
