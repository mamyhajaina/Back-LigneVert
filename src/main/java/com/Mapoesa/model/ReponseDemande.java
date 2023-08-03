package com.Mapoesa.model;
import java.sql.Timestamp;

import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "reponseDemande")
public class ReponseDemande{
	
	@Column(name = "idReponseDemande" )
	private int idReponseDemande;
	 
	@Column(name = "idAppel" )
	private int idAppel;
	
	
	@Column(name = "reponse" )
	private String reponse;
	
	@Column(name = "idstatut" )
	private Integer idstatut;
	
	@Column(name = "idUtiliateur" )
	private Integer idUtiliateur;
	
	@Column(name = "vu" )
	private Boolean vu;
	
	@Column(name = "reponseDemande" )
	private Boolean reponseDemande;
	
	@Column(name = "intervention" )
	private String intervention;
	
	@Column(name = "constatResolution" )
	private String constatResolution;
	
	@Column(name = "dateInsertion" )
	private Timestamp dateInsertion;
	
	private Appel appel;
	private String nomStatus;

	
	
	public Boolean getReponseDemande() {
		return reponseDemande;
	}

	public void setReponseDemande(Boolean reponseDemande) {
		this.reponseDemande = reponseDemande;
	}

	public String getIntervention() {
		return intervention;
	}

	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}

	public String getConstatResolution() {
		return constatResolution;
	}

	public void setConstatResolution(String constatResolution) {
		this.constatResolution = constatResolution;
	}

	public Timestamp getDateInsertion() {
		return dateInsertion;
	}

	public void setDateInsertion(Timestamp dateInsertion) {
		this.dateInsertion = dateInsertion;
	}

	public Appel getAppel() {
		return appel;
	}

	public void setAppel(Appel appel) {
		this.appel = appel;
	}

	public String getNomStatus() {
		return nomStatus;
	}

	public void setNomStatus(String nomStatus) {
		this.nomStatus = nomStatus;
	}

	public int getIdReponseDemande() {
		return idReponseDemande;
	}

	public void setIdReponseDemande(int idReponseDemande) {
		this.idReponseDemande = idReponseDemande;
	}

	public int getIdAppel() {
		return idAppel;
	}

	public void setIdAppel(int idAppel) {
		this.idAppel = idAppel;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Integer getIdstatut() {
		return idstatut;
	}

	public void setIdstatut(Integer idstatut) {
		this.idstatut = idstatut;
	}

	public Integer getIdUtiliateur() {
		return idUtiliateur;
	}

	public void setIdUtiliateur(Integer idUtiliateur) {
		this.idUtiliateur = idUtiliateur;
	}

	public Boolean getVu() {
		return vu;
	}

	public void setVu(Boolean vu) {
		this.vu = vu;
	}
	
	
	
}
