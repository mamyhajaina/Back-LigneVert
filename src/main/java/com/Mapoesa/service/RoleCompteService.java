package com.Mapoesa.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.RoleCompte;
import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class RoleCompteService {
	
	public RoleCompte findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<RoleCompte> refs =  GenericRepo.find(RoleCompte.class, con, "idRoleCompte=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
				con.rollback();
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<RoleCompte> findAll(Connection con ) throws Exception {
		try { 
			List<RoleCompte> refs =  GenericRepo.find(RoleCompte.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
				con.rollback();
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(RoleCompte input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}
	
	public void update(RoleCompte input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "id_personne = ?",input.getIdRoleCompte());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
