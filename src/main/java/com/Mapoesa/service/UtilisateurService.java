package com.Mapoesa.service;
import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Mapoesa.model.Utilisateur;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class UtilisateurService {
	
	@Autowired
	OthersFunction othersFunction;
	
	public Utilisateur login(String adresseMail,String motsDePasse,Connection con ) throws Exception {
		 
		try { 
			String sha1Mail=this.othersFunction.convertToSHA1(motsDePasse);
			String sha1Mtps=this.othersFunction.convertToSHA1(adresseMail);
			System.out.println("sha1Mail: " + sha1Mail);
			System.out.println("sha1Mtps: " + sha1Mtps);
			List<Utilisateur> refs =  GenericRepo.find(Utilisateur.class, con, "motsDePasse=? and adresseMail=?", sha1Mtps , sha1Mail);
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public Utilisateur findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Utilisateur> refs =  GenericRepo.find(Utilisateur.class, con, "idRoleCompte=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Utilisateur> findAll(Connection con ) throws Exception {
		try { 
			List<Utilisateur> refs =  GenericRepo.find(Utilisateur.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Utilisateur input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
		}

	}
	
	public void update(Utilisateur input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "id_personne = ?",input.getIdUtiliateur());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
