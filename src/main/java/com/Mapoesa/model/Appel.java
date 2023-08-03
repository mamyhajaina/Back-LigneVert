package com.Mapoesa.model;
 
import java.sql.Date;

import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "appel")
public class Appel{
	
	 
	@Column(name = "idAppel" )
	private int idAppel;
	
	@Column(name = "nomAppelant" )
	private String nomAppelant;
	
	@Column(name = "numeroAppelant" )
	private String numeroAppelant;
	
	@Column(name = "sexe" )
	private String sexe;
	
	@Column(name = "resumeAppel" )
	private String resumeAppel;
	
	@Column(name = "idCategireAppel" )
	private Integer idCategireAppel;
	
	@Column(name = "idVolet" )
	private Integer idVolet;

	@Column(name = "idActivites" )
	private Integer idActivites;
	
	@Column(name = "idDetailsActivites" )
	private Integer idDetailsActivites;
	
	@Column(name = "idRegion" )
	private Integer idRegion;
	
	@Column(name = "idDistrique" )
	private Integer idDistrique;
	
	@Column(name = "categorieSocioProAppelant" )
	private String categorieSocioProAppelant;
	
	@Column(name = "idProjet" )
	private Integer idProjet;
	
	@Column(name = "dateAppel" )
	private Date dateAppel;
	
	@Column(name = "dateModification" )
	private Date dateModification;
	
	@Column(name = "idUtiliateur" )
	private Integer idUtiliateur;
	
	@Column(name = "idPriorite" )
	private Integer idPriorite;
	
	@Column(name = "reponseVu" )
	private Integer reponseVu;
	
	Projet projet;
	Volet volet;
	Region region;
	Distrique distrique;
	
	
	public Integer getReponseVu() {
		return reponseVu;
	}
	public void setReponseVu(Integer reponseVu) {
		this.reponseVu = reponseVu;
	}
	public int getIdAppel() {
		return idAppel;
	}
	public void setIdAppel(int idAppel) {
		this.idAppel = idAppel;
	}
	public String getNomAppelant() {
		return nomAppelant;
	}
	public void setNomAppelant(String nomAppelant) {
		this.nomAppelant = nomAppelant;
	}
	public String getNumeroAppelant() {
		return numeroAppelant;
	}
	public void setNumeroAppelant(String numeroAppelant) {
		this.numeroAppelant = numeroAppelant;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getResumeAppel() {
		return resumeAppel;
	}
	public void setResumeAppel(String resumeAppel) {
		this.resumeAppel = resumeAppel;
	}
	public Integer getIdCategireAppel() {
		return idCategireAppel;
	}
	public void setIdCategireAppel(Integer idCategireAppel) {
		this.idCategireAppel = idCategireAppel;
	}
	public Integer getIdVolet() {
		return idVolet;
	}
	public void setIdVolet(Integer idVolet) {
		this.idVolet = idVolet;
	}
	public Integer getIdActivites() {
		return idActivites;
	}
	public void setIdActivites(Integer idActivites) {
		this.idActivites = idActivites;
	}
	public Integer getIdDetailsActivites() {
		return idDetailsActivites;
	}
	public void setIdDetailsActivites(Integer idDetailsActivites) {
		this.idDetailsActivites = idDetailsActivites;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public Integer getIdDistrique() {
		return idDistrique;
	}
	public void setIdDistrique(Integer idDistrique) {
		this.idDistrique = idDistrique;
	}
	public String getCategorieSocioProAppelant() {
		return categorieSocioProAppelant;
	}
	public void setCategorieSocioProAppelant(String categorieSocioProAppelant) {
		this.categorieSocioProAppelant = categorieSocioProAppelant;
	}
	public Integer getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}
	public Date getDateAppel() {
		return dateAppel;
	}
	public void setDateAppel(Date dateAppel) {
		this.dateAppel = dateAppel;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Integer getIdUtiliateur() {
		return idUtiliateur;
	}
	public void setIdUtiliateur(Integer idUtiliateur) {
		this.idUtiliateur = idUtiliateur;
	}
	public Integer getIdPriorite() {
		return idPriorite;
	}
	public void setIdPriorite(Integer idPriorite) {
		this.idPriorite = idPriorite;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Volet getVolet() {
		return volet;
	}
	public void setVolet(Volet volet) {
		this.volet = volet;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Distrique getDistrique() {
		return distrique;
	}
	public void setDistrique(Distrique distrique) {
		this.distrique = distrique;
	}
	
	

	
	
	
}
