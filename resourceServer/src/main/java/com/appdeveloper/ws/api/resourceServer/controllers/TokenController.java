package com.appdeveloper.ws.api.resourceServer.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

	@GetMapping()
	public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
		return Collections.singletonMap("principal", jwt);
	}
	
	@PreAuthorize("hasRole('developer') or #id == jwt.subject")
//	@Secured("ROLE_developer")
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "deleted";
	}
}
