package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Priorite;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class PrioriteService {
	
	public Priorite findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<Priorite> refs =  GenericRepo.find(Priorite.class, con, "idDistrique=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<Priorite> findAll(Connection con ) throws Exception {
		try { 
			List<Priorite> refs =  GenericRepo.find(Priorite.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(Priorite input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(Priorite input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idDistrique = ?",input.getIdPriorite());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
