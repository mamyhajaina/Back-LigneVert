package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Projet;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class ProjetService {
	
	public Projet findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Projet> refs =  GenericRepo.find(Projet.class, con, "idProjet=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Projet> findAll(Connection con ) throws Exception {
		try { 
			List<Projet> refs =  GenericRepo.find(Projet.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Projet input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Projet input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idProjet = ?",input.getIdProjet());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
