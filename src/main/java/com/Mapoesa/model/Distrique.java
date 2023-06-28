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
