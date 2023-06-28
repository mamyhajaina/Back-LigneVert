package com.Mapoesa.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class OthersFunction {
	
	public String convertToSHA1(String input) {
        try {
            // Création d'une instance de MessageDigest avec l'algorithme SHA-1
            MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");

            // Conversion de la chaîne de caractères en un tableau de bytes
            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);

            // Calcul du hash SHA-1
            byte[] sha1Hash = sha1Digest.digest(inputBytes);

            // Conversion du hash en une représentation hexadécimale
            StringBuilder hexBuilder = new StringBuilder();
            for (byte b : sha1Hash) {
                String hex = String.format("%02x", b);
                hexBuilder.append(hex);
            }
            return hexBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
