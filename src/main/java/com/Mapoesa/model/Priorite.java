package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "priorite")
public class Priorite{
	
	 
	@Column(name = "idPriorite" )
	private int idPriorite;
	 
	@Column(name = "nomPriorite" )
	private String nomPriorite;

	public int getIdPriorite() {
		return idPriorite;
	}

	public void setIdPriorite(int idPriorite) {
		this.idPriorite = idPriorite;
	}

	public String getNomPriorite() {
		return nomPriorite;
	}

	public void setNomPriorite(String nomPriorite) {
		this.nomPriorite = nomPriorite;
	}

	
	
}
