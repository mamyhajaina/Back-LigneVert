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
public class ReponseHttp {

    private String message;
    private Object contenu;

    public ReponseHttp() {
    }

    public ReponseHttp(String message, Object contenu) {
        this.message = message;
        this.contenu = contenu;
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
}
