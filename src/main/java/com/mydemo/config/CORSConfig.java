package com.mydemo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfig {
    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurerAdapter() {
              @Override
              public void addCorsMappings(CorsRegistry  registry){
                   registry.addMapping("/**")
                           .allowedOrigins(CorsConfiguration.ALL)
                           .allowedMethods(CorsConfiguration.ALL)
                           .allowedHeaders(CorsConfiguration.ALL)
                           .allowCredentials(true);
              }
        };
    }
}
