package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.DetailsActivite;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class DetailsActiviteService {
	
	public List<DetailsActivite> findByIdActivites(int idActivites,Connection con ) throws Exception {
		try { 
			List<DetailsActivite> refs =  GenericRepo.find(DetailsActivite.class, con,"idActivites=?",idActivites);
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public DetailsActivite findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<DetailsActivite> refs =  GenericRepo.find(DetailsActivite.class, con, "idvolet=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<DetailsActivite> findAll(Connection con ) throws Exception {
		try { 
			List<DetailsActivite> refs =  GenericRepo.find(DetailsActivite.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(DetailsActivite input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(DetailsActivite input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idProjet = ?",input.getIdDetailsActivites());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
