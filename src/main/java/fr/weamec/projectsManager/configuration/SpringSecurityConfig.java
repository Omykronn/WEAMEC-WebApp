/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuration pour la gestion de l'authentification et des autorisations
 * @author simon
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    /**
     * Crée une chaîne de filtres HTTP
     * @param http  Instance de HttpSecurity
     * @return      Chaîne de filtres
     * @throws Exception Erreur lors de la création de la chaîne
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/admin/**").hasRole("ADMIN");
                    auth.requestMatchers("/projects/**").hasRole("USER");
                    auth.requestMatchers("/file/**").hasRole("USER");
                    
                    auth.anyRequest().authenticated();
            }).formLogin(Customizer.withDefaults()).build();
    }
    
    /**
     * Construction d'un gestionnaire des authentifications
     * @param http  HttpSecurity
     * @param bCryptPasswordEncoder Outils de chiffrement BCrypt
     * @return  Gestionnaire des authentification
     * @throws Exception Erreur lors de la construction
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
            return authenticationManagerBuilder.build();
    }
    
    @Bean
    /**
     * Instanciation d'un outils de chiffrement BCrypt
     */
    public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
    }
    
    /**
     * Définition de la hiearchie des rôles
     * @return Hiéarchie des rôles
     */
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
}
