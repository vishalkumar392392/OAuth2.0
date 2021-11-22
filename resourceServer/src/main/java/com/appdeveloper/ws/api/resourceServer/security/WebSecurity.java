package com.appdeveloper.ws.api.resourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
		jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/users/status/check")
//								.hasAuthority("SCOPE_profile")
				.hasRole("developer").anyRequest().authenticated().and().oauth2ResourceServer().jwt()
				.jwtAuthenticationConverter(jwtConverter);
	}

}
