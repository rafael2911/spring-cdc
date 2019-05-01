package br.com.cr.springcdc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.cr.springcdc.dao.UsuarioDao;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/carrinho/**").permitAll()
			.antMatchers("/pagamento/**").permitAll()
			.antMatchers("/url-magica-maluca-kaksfojssklfbmaiwrunf6o5ol206l1k").permitAll()
			.antMatchers("/produto/form").hasRole("ADMIN")
			.antMatchers("/produto/form/").hasRole("ADMIN")
			.antMatchers("/produto/").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/produto").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/produto").hasRole("ADMIN")
			.antMatchers("/produto/**").permitAll()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
