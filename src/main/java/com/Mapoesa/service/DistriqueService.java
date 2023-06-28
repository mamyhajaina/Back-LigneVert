package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Distrique;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class DistriqueService {
	
	public Distrique findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Distrique> refs =  GenericRepo.find(Distrique.class, con, "idDistrique=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Distrique> findAll(Connection con ) throws Exception {
		try { 
			List<Distrique> refs =  GenericRepo.find(Distrique.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Distrique input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Distrique input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idDistrique = ?",input.getIdDistrique());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
