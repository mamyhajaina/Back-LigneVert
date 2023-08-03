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
import com.Mapoesa.model.ReponseDemande;
import com.Mapoesa.models.utils.EnumMessages;
import com.Mapoesa.models.utils.ReponseHttp;
import com.Mapoesa.service.ReponseDemandeService;


@RestController
@RequestMapping("reponseDemande")
public class ReponseDemandeController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	ReponseDemandeService service;
	
	@GetMapping("/nonRepondu")
	public ResponseEntity<ReponseHttp> nonRepondu(@RequestParam int idProjet) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.getByIdProjetNomRepondu(idProjet,con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/id")
	public ResponseEntity<ReponseHttp> id(@RequestParam int idProjet) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.getByIdProjet(idProjet,con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@GetMapping("/delete/id")
	public ResponseEntity<ReponseHttp> deleteById(@RequestParam int id) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			ReponseDemande reponseDemande= new ReponseDemande();
			reponseDemande.setIdReponseDemande(id);;
			this.service.delete(reponseDemande,con);
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
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),this.service.findAll(con));
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
	@PostMapping("/inserte")
	public ResponseEntity<ReponseHttp> inserte(@RequestBody ReponseDemande inpute) throws SQLException 
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
	public ResponseEntity<ReponseHttp> uptade(@RequestBody ReponseDemande inpute) throws SQLException 
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
