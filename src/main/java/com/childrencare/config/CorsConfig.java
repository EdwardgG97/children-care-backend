package com.childrencare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * Configuración de CORS (Cross-Origin Resource Sharing).
 * 
 * Esta configuración permite que el frontend (que puede estar en un dominio diferente)
 * pueda consumir la API REST sin problemas de seguridad del navegador.
 * 
 * CORS es un mecanismo de seguridad que los navegadores implementan para restringir
 * peticiones cross-origin (peticiones de un dominio a otro).
 * 
 * En desarrollo, usualmente permitimos todos los orígenes. En producción,
 * se debe restringir a dominios específicos.
 */
@Configuration
public class CorsConfig {

    /**
     * Configura el filtro CORS para permitir peticiones desde cualquier origen.
     * 
     * En un entorno de producción, se debe restringir a dominios específicos
     * por razones de seguridad.
     * 
     * @return El filtro CORS configurado
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // Permitir peticiones desde cualquier origen (útil para desarrollo)
        // En producción, reemplazar "*" con dominios específicos, ej: "http://localhost:3000"
        config.setAllowedOriginPatterns(List.of("*"));
        
        // Permitir todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        
        // Permitir todos los headers
        config.setAllowedHeaders(List.of("*"));
        
        // Permitir credenciales (cookies, authorization headers)
        config.setAllowCredentials(true);
        
        // Tiempo máximo de caché de la preflight request (en segundos)
        config.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
