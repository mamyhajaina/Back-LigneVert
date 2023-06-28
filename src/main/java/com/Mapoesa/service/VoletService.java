package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Volet;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class VoletService {
	
	public List<Volet> findByIdProjet(int idprojet,Connection con ) throws Exception {
		try { 
			List<Volet> refs =  GenericRepo.find(Volet.class, con,"idProjet=?",idprojet);
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public Volet findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Volet> refs =  GenericRepo.find(Volet.class, con, "idvolet=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Volet> findAll(Connection con ) throws Exception {
		try { 
			List<Volet> refs =  GenericRepo.find(Volet.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Volet input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Volet input,Connection conn) throws Exception {
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
