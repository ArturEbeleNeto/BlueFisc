package br.com.consultoria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService usuarioDao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 CharacterEncodingFilter filter = new CharacterEncodingFilter();
	     filter.setEncoding("UTF-8");
	     filter.setForceEncoding(true);
	     http.addFilterBefore(filter,CsrfFilter.class);		
		
	     http.authorizeRequests().anyRequest().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}