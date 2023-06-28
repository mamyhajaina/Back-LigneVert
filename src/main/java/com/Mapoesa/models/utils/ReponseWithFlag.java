/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Mapoesa.models.utils;

/**
 *
 * @author hp
 */
public class ReponseWithFlag {

    private String message;
    private Object contenu;
    private Boolean flag;

    public ReponseWithFlag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReponseWithFlag(String message, Object contenu, Boolean flag) {
		super();
		this.message = message;
		this.contenu = contenu;
		this.flag = flag;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContenu() {
        return contenu;
    }

    public void setContenu(Object contenu) {
        this.contenu = contenu;
    }

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
    
}
