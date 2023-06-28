package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Region;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class RegionService {
	
	public List<Region> findByIdProjet(int id,Connection con ) throws Exception {
		 
		try { 
			List<Region> refs =  GenericRepo.find(Region.class, con, "idProjet=?",id );
			 
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public Region findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Region> refs =  GenericRepo.find(Region.class, con, "idRegion=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Region> findAll(Connection con ) throws Exception {
		try { 
			List<Region> refs =  GenericRepo.find(Region.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Region input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Region input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "id_personne = ?",input.getIdRegion());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
