package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "commune")
public class Commune{
	
	 
	@Column(name = "idCommune" )
	private int idCommune;
	 
	@Column(name = "nomCommune" )
	private String nomCommune;

	@Column(name = "idDistrique" )
	private int idDistrique;

	public int getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(int idCommune) {
		this.idCommune = idCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public int getIdDistrique() {
		return idDistrique;
	}

	public void setIdDistrique(int idDistrique) {
		this.idDistrique = idDistrique;
	}

	
	
	
}
