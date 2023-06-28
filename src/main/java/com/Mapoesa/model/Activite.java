package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "activites")
public class Activite{
	
	 
	@Column(name = "idActivites" )
	private int idActivites;
	 
	@Column(name = "nomActivites" )
	private String nomActivites;

	@Column(name = "idVolet" )
	private int idVolet;

	public int getIdActivites() {
		return idActivites;
	}

	public void setIdActivites(int idActivites) {
		this.idActivites = idActivites;
	}

	public String getNomActivites() {
		return nomActivites;
	}

	public void setNomActivites(String nomActivites) {
		this.nomActivites = nomActivites;
	}

	public int getIdVolet() {
		return idVolet;
	}

	public void setIdVolet(int idVolet) {
		this.idVolet = idVolet;
	}

	
	
}
