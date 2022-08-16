package com.wipro.register_service.JWTFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.register_service.service.registerService;
import com.wipro.register_service.utility.JWTUtilityClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTFilter extends OncePerRequestFilter {
	
	@Autowired
	JWTUtilityClass JWTUtil;
	
	@Autowired
	registerService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authorizationHeader=request.getHeader("Authorization");
		String token=null;
		String email=null;
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
			token=authorizationHeader.substring(7);
			email=JWTUtil.extractUsername(token);
		}
		System.out.println(SecurityContextHolder.getContext().getAuthentication()==null);
		if(email!=null && SecurityContextHolder.getContext()!=null) {
			System.out.println("This condition passed");
			UserDetails UserDetails = service.loadUserByUsername(email);
			if(JWTUtil.validateToken(token, UserDetails)) {
				UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(UserDetails,null,UserDetails.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
