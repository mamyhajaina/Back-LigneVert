package com.Mapoesa.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.Mapoesa.model.Appel;
import com.Mapoesa.model.Distrique;
import com.Mapoesa.model.Projet;
import com.Mapoesa.model.Region;
import com.Mapoesa.model.ReponseDemande;
import com.Mapoesa.model.Volet;

import mg.manohisoa.databasePersistence.GenericRepo;

@Service
public class ReponseDemandeService {
	
	public List<ReponseDemande> getByIdProjet(int idProjet, Connection conn)throws Exception {
		List<ReponseDemande> listcursus=new ArrayList<ReponseDemande>();
		String requete = "select rd.reponseDemande ,rd.idReponseDemande ,s.nomStatus ,rd.vu,rd.idstatut ,a.idAppel, a.nomAppelant, a.numeroAppelant, a.resumeAppel, a.idProjet,a.idCategireAppel , p.nomProjet, p.couleur , v.nomVolet, r.nomRegion, d.nomDistrique, d.commune, d.fokotany"
				+ "    from reponseDemande rd"
				+ "        inner join appel a on rd.idAppel = a.idAppel"
				+ "		   left join status s on rd.idstatut = s.idstatut"
				+ "        left join projet p on a.idProjet = p.idProjet"
				+ "        left join volet v on a.idVolet = v.idVolet"
				+ "        left join region r on a.idRegion = r.idRegion"
				+ "        left join distrique d on a.idDistrique = d.idDistrique"
				+ "        where a.idProjet = " + idProjet;
		ResultSet rs2;
		try (Statement st2 = conn.createStatement()) {
			rs2 = st2.executeQuery(requete);
			while (rs2.next()) {
				System.out.println("nomAppelant: " + rs2.getString("nomAppelant"));
				ReponseDemande reponseDemande = new ReponseDemande();
				reponseDemande.setVu(rs2.getBoolean("vu"));
				reponseDemande.setIdstatut(rs2.getInt("idstatut"));
				reponseDemande.setNomStatus(rs2.getString("nomStatus"));
				reponseDemande.setIdReponseDemande(rs2.getInt("idReponseDemande"));
				reponseDemande.setReponseDemande(rs2.getBoolean("reponseDemande"));
					Appel appel= new Appel();
					appel.setIdAppel(rs2.getInt("idAppel"));
					appel.setNomAppelant(rs2.getString("nomAppelant"));
					appel.setNumeroAppelant(rs2.getString("numeroAppelant"));
					appel.setResumeAppel(rs2.getString("resumeAppel"));
					appel.setIdCategireAppel(rs2.getInt("idCategireAppel"));
						Projet projet=new Projet();
						projet.setNomProjet(rs2.getString("nomProjet"));
						projet.setCouleur(rs2.getString("couleur"));
					appel.setProjet(projet);
						Volet volet=new Volet();
						volet.setNomVolet(rs2.getString("nomVolet"));
					appel.setVolet(volet);
						Region region=new Region();
						region.setNomRegion(rs2.getString("nomRegion"));
					appel.setRegion(region);
						Distrique distrique=new Distrique();
						distrique.setNomDistrique(rs2.getString("nomDistrique"));
						distrique.setCommune(rs2.getString("commune"));
						distrique.setFokotany(rs2.getString("fokotany"));
					appel.setDistrique(distrique);
				reponseDemande.setAppel(appel);
				listcursus.add(reponseDemande);
			}
		}
		rs2.close();
		return listcursus;
	}
	
	public List<ReponseDemande> getByIdProjetNomRepondu(int idProjet, Connection conn)throws Exception {
		List<ReponseDemande> listcursus=new ArrayList<ReponseDemande>();
		String requete = "select rd.reponseDemande ,rd.idReponseDemande ,s.nomStatus ,rd.vu,rd.idstatut ,a.idAppel, a.nomAppelant, a.numeroAppelant, a.resumeAppel, a.idProjet,a.idCategireAppel , p.nomProjet, p.couleur , v.nomVolet, r.nomRegion, d.nomDistrique, d.commune, d.fokotany"
				+ "    from reponseDemande rd"
				+ "        inner join appel a on rd.idAppel = a.idAppel"
				+ "		   left join status s on rd.idstatut = s.idstatut"
				+ "        left join projet p on a.idProjet = p.idProjet"
				+ "        left join volet v on a.idVolet = v.idVolet"
				+ "        left join region r on a.idRegion = r.idRegion"
				+ "        left join distrique d on a.idDistrique = d.idDistrique"
				+ "        where a.idProjet = " + idProjet
				+ "        	AND rd.reponseDemande is null";
		ResultSet rs2;
		try (Statement st2 = conn.createStatement()) {
			rs2 = st2.executeQuery(requete);
			while (rs2.next()) {
				System.out.println("nomAppelant: " + rs2.getString("nomAppelant"));
				ReponseDemande reponseDemande = new ReponseDemande();
				reponseDemande.setVu(rs2.getBoolean("vu"));
				reponseDemande.setIdstatut(rs2.getInt("idstatut"));
				reponseDemande.setNomStatus(rs2.getString("nomStatus"));
				reponseDemande.setIdReponseDemande(rs2.getInt("idReponseDemande"));
				reponseDemande.setReponseDemande(rs2.getBoolean("reponseDemande"));
					Appel appel= new Appel();
					appel.setIdAppel(rs2.getInt("idAppel"));
					appel.setNomAppelant(rs2.getString("nomAppelant"));
					appel.setNumeroAppelant(rs2.getString("numeroAppelant"));
					appel.setResumeAppel(rs2.getString("resumeAppel"));
					appel.setIdCategireAppel(rs2.getInt("idCategireAppel"));
						Projet projet=new Projet();
						projet.setNomProjet(rs2.getString("nomProjet"));
						projet.setCouleur(rs2.getString("couleur"));
					appel.setProjet(projet);
						Volet volet=new Volet();
						volet.setNomVolet(rs2.getString("nomVolet"));
					appel.setVolet(volet);
						Region region=new Region();
						region.setNomRegion(rs2.getString("nomRegion"));
					appel.setRegion(region);
						Distrique distrique=new Distrique();
						distrique.setNomDistrique(rs2.getString("nomDistrique"));
						distrique.setCommune(rs2.getString("commune"));
						distrique.setFokotany(rs2.getString("fokotany"));
					appel.setDistrique(distrique);
				reponseDemande.setAppel(appel);
				listcursus.add(reponseDemande);
			}
		}
		rs2.close();
		return listcursus;
	}
	
	public ReponseDemande findById(int id,Connection con ) throws Exception {
		 
		try { 
			List<ReponseDemande> refs =  GenericRepo.find(ReponseDemande.class, con, "idReponseDemande=?",id );
			 
			return refs.isEmpty() ? null: refs.get(0);
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public List<ReponseDemande> findAll(Connection con ) throws Exception {
		try { 
			List<ReponseDemande> refs =  GenericRepo.find(ReponseDemande.class, con,"");
			return refs;
		} catch (Exception e) {
			if (con != null) {
			}
			e.printStackTrace();
			throw e;
		} 

	}
	
	public void save(ReponseDemande input,Connection conn) throws Exception {
		try { 
			GenericRepo.insert(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				
		}

	}
	
	public void delete(ReponseDemande input,Connection conn) throws Exception {
		try { 
			GenericRepo.delete(input, conn);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		} finally {
				
		}

	}
	
	public void update(ReponseDemande input,Connection conn) throws Exception {
		try { 
			GenericRepo.update(input, conn, "idReponseDemande = ?",input.getIdReponseDemande());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
				conn.commit();
		}

	}

}
