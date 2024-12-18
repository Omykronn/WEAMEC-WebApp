package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.CustomUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import fr.weamec.projectsManager.repository.CustomUserRepository;
import org.springframework.security.core.userdetails.User;

/**
 * Service de gestion des utilisateurs
 * @author simon
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private CustomUserRepository customUserRepository;
        
        /**
         * Crée un User à partir des informations dans la base de données et son nom d'utilisateur
         * @param username  Nom de l'utilisateur
         * @return          User complété
         * @throws UsernameNotFoundException Le nom d'utilisateur n'existe pas dans la base de données
         */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUser user = customUserRepository.findByUsername(username);
		
		return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRole()));
	}
        
        /**
         * Retourne une liste de GrantedAuthority à partir du nom d'un role
         * @param role  Nom du role
         * @return      Liste de GrantedAuthority
         */
	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}
}