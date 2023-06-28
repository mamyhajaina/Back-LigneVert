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
public enum EnumMessages {

    SELECT_SUCCESS("Données recupérées"),
	INSERTION_AVEC_SUCCESS("Donnée enregistrée"),
	DELETE_SUCCESS("Donnée supprimeée"),
	UPDATE_AVEC_SUCCESS("Donnée modifiée");
    
    private final String message;

    private EnumMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
