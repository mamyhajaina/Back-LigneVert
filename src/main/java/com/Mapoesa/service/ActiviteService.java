package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Activite;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class ActiviteService {
	
	public List<Activite> findByIdVolet(int idVolet,Connection con ) throws Exception {
		try { 
			List<Activite> refs =  GenericRepo.find(Activite.class, con,"idVolet=?",idVolet);
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public Activite findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Activite> refs =  GenericRepo.find(Activite.class, con, "idvolet=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Activite> findAll(Connection con ) throws Exception {
		try { 
			List<Activite> refs =  GenericRepo.find(Activite.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Activite input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Activite input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idProjet = ?",input.getIdActivites());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
