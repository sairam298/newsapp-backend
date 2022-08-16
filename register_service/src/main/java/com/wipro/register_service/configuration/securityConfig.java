package com.wipro.register_service.configuration;

import com.wipro.register_service.JWTFilter.JWTFilter;
import com.wipro.register_service.service.registerService;
import com.wipro.register_service.utility.JWTUtilityClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	JWTFilter jwtFilter;
	
	@Autowired
	registerService regserv;
	
	@Autowired
	JWTUtilityClass jwtUtil;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(regserv);
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/user/register","/user/authenticate","/user/**","/**")
		.permitAll().anyRequest().authenticated()
		 .and().exceptionHandling().and().sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
