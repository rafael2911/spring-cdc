package br.com.cr.springcdc.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.cr.springcdc.model.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Usuario loadUserByUsername(String email) {
		Usuario usuario = null;
		
		try {
			usuario = manager.createQuery("FROM Usuario u WHERE u.email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
		}catch (NoResultException ex) {
			throw new UsernameNotFoundException("O usuario " + email + " não foi encontrado.");
		}
		
		return usuario;
	}
	
}
