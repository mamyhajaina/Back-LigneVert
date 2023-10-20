package com.Mapoesa.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Mapoesa.model.Appel;
import com.Mapoesa.model.ReponseDemande;
import com.Mapoesa.models.utils.EnumMessages;
import com.Mapoesa.models.utils.ReponseHttp;
import com.Mapoesa.service.AppelService;
import com.Mapoesa.service.ReponseDemandeService;


@RestController
@RequestMapping("appel")
public class AppelController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	AppelService service;
	
	@Autowired
	ReponseDemandeService reponseDemandeService;
	
	@GetMapping("/envoyer")
	public ResponseEntity<ReponseHttp> reponse(@RequestParam int idAppel,@RequestParam int idUtiliateur) throws SQLException 
	{
		Connection con=null;
		try {	
			con=jdbc.getDataSource().getConnection();
			con.setAutoCommit(false);
			ReponseDemande reponseDemande = new ReponseDemande();
			reponseDemande.setIdAppel(idAppel);
			reponseDemande.setIdUtiliateur(idUtiliateur);
			this.reponseDemandeService.save(reponseDemande, con);
			Appel appel =new Appel();
			appel.setIdAppel(idAppel);
			appel.setReponseVu(1);
			this.service.update(appel, con);
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),"ok");
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
				con.commit();
			}
	}
	
	@GetMapping("/idAppel")
	public ResponseEntity<ReponseHttp> findById(@RequestParam int idAppel) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.getById(idAppel,con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/idProjet")
	public ResponseEntity<ReponseHttp> findByIdProjet(@RequestParam int idProjet) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.findByIdProjet(idProjet,con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/id")
	public ResponseEntity<ReponseHttp> id(@RequestParam int id) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.findById(id,con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/delete/id")
	public ResponseEntity<ReponseHttp> deleteById(@RequestParam int idAppel) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			Appel appel= new Appel();
			appel.setIdAppel(idAppel);
			this.service.delete(appel,con);
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),"Ok");
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/all")
	public ResponseEntity<ReponseHttp> all() throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.getAll(con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@PostMapping("/inserte")
	public ResponseEntity<ReponseHttp> inserte(@RequestBody Appel inpute) throws SQLException 
	{
		Connection con=null;
		try {	
			con=jdbc.getDataSource().getConnection();
			con.setAutoCommit(false);
			this.service.save(inpute, con);
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),"ok");
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
				con.commit();
			}
	}
	
	@PostMapping("/update")
	public ResponseEntity<ReponseHttp> uptade(@RequestBody Appel inpute) throws SQLException 
	{
		Connection con=null;
		try {	
			con=jdbc.getDataSource().getConnection();
			con.setAutoCommit(false);
			this.service.update(inpute, con);
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),"ok");
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
				con.commit();
			}
	}
	
}
