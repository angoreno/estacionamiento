package cl.ejemplo.iep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cl.ejemplo.iep.services.UsuarioService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
				 
	}
	

}
