package com.Mapoesa.model;
 
import mg.manohisoa.databasePersistence.annotation.Column;
import mg.manohisoa.databasePersistence.annotation.Entity;
import mg.manohisoa.databasePersistence.annotation.Table;

@Entity
@Table(name = "roleCompte")
public class RoleCompte{
	
	 
	@Column(name = "idRoleCompte" )
	private int idRoleCompte;
	 
	@Column(name = "role" )
	private String role;


	
	public int getIdRoleCompte() {
		return idRoleCompte;
	}

	public void setIdRoleCompte(int idRoleCompte) {
		this.idRoleCompte = idRoleCompte;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public RoleCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleCompte(int idRoleCompte, String role) {
		super();
		this.idRoleCompte = idRoleCompte;
		this.role = role;
	}
	
	
	
	
}
