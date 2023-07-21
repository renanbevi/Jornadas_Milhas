package br.com.alura.challenge.viagem.model.infra.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Compartilhamento {

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080") // Permitir requisições de qualquer origem (URL)
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                    .allowedHeaders("*"); // Headers permitidos
        }
    }
}
