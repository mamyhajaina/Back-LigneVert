package com.Mapoesa.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Mapoesa.model.Projet;
import com.Mapoesa.models.utils.EnumMessages;
import com.Mapoesa.models.utils.ReponseHttp;
import com.Mapoesa.service.ProjetService;


@RestController
@RequestMapping("projet")
public class ProjetController {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	ProjetService service;
	
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
	
	@GetMapping("/inserte")
	public ResponseEntity<ReponseHttp> inserte(@RequestBody Projet inpute) throws SQLException 
	{
		try (Connection con=jdbc.getDataSource().getConnection()) {	
			this.service.save(inpute, con);
			ReponseHttp rep = new ReponseHttp(EnumMessages.SELECT_SUCCESS.getMessage(),"ok");
			return new ResponseEntity<>(rep, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				ReponseHttp rep = new ReponseHttp(e.getMessage(),null);
				return new ResponseEntity<ReponseHttp>(rep, HttpStatus.BAD_REQUEST);
			}finally {
			}
	}
	
}
