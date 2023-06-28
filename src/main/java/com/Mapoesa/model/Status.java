package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "status")
public class Status{
	
	 
	@Column(name = "idstatut" )
	private int idstatut;
	 
	@Column(name = "nomStatus" )
	private String nomStatus;

	public int getIdstatut() {
		return idstatut;
	}

	public void setIdstatut(int idstatut) {
		this.idstatut = idstatut;
	}

	public String getNomStatus() {
		return nomStatus;
	}

	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
	}

	
}
