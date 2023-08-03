package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur{
	
	 
	@Column(name = "idUtiliateur" )
	private int idUtiliateur;
	 
	@Column(name = "nom" )
	private String nom;
	
	@Column(name = "prenom" )
	private String prenom;
	
	@Column(name = "age" )
	private Integer age;
	
	@Column(name = "sexe" )
	private String sexe;
	
	@Column(name = "adresse" )
	private String adresse;
	
	@Column(name = "adresseMail" )
	private String adresseMail;
	
	@Column(name = "motsDePasse" )
	private String motsDePasse;
	
	@Column(name = "idRoleCompte" )
	private Integer idRoleCompte;
	
	@Column(name = "idProjet" )
	private Integer idProjet;
	
	private RoleCompte roleCompte;

	
	



	public Integer getIdProjet() {
		return idProjet;
	}



	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
	}



	public int getIdUtiliateur() {
		return idUtiliateur;
	}



	public void setIdUtiliateur(int idUtiliateur) {
		this.idUtiliateur = idUtiliateur;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public String getAdresse() {
		return adresse;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public RoleCompte getRoleCompte() {
		return roleCompte;
	}



	public void setRoleCompte(RoleCompte roleCompte) {
		this.roleCompte = roleCompte;
	}



	public String getAdresseMail() {
		return adresseMail;
	}



	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}



	public String getMotsDePasse() {
		return motsDePasse;
	}



	public void setMotsDePasse(String motsDePasse) {
		this.motsDePasse = motsDePasse;
	}



	public Utilisateur() {
		super();
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Integer getIdRoleCompte() {
		return idRoleCompte;
	}



	public void setIdRoleCompte(Integer idRoleCompte) {
		this.idRoleCompte = idRoleCompte;
	}
	
	


	

	
	
}
