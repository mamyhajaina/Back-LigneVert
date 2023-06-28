package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "detailsActivites")
public class DetailsActivite{
	
	 
	@Column(name = "idDetailsActivites" )
	private int idDetailsActivites;
	 
	@Column(name = "nomDetailsActivites" )
	private String nomDetailsActivites;

	@Column(name = "idActivites" )
	private int idActivites;

	public int getIdDetailsActivites() {
		return idDetailsActivites;
	}

	public void setIdDetailsActivites(int idDetailsActivites) {
		this.idDetailsActivites = idDetailsActivites;
	}

	public String getNomDetailsActivites() {
		return nomDetailsActivites;
	}

	public void setNomDetailsActivites(String nomDetailsActivites) {
		this.nomDetailsActivites = nomDetailsActivites;
	}

	public int getIdActivites() {
		return idActivites;
	}

	public void setIdActivites(int idActivites) {
		this.idActivites = idActivites;
	}

	
	
	
}
