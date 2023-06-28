package com.Mapoesa.configue;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfigue implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // L'URL de votre API
				.allowedOrigins("http://localhost:4200") // L'URL de votre application Angular
				.allowedMethods("OPTIONS", "POST", "GET", "PUT", "DELETE") // Méthodes HTTP autorisées
				.allowedHeaders("*") // En-têtes autorisés
                .allowCredentials(true); // Autoriser les cookies;
	}

}
