package br.com.izifinance.izianalyse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.izifinance.izianalyse.dto.AuthenticationOutputDto;
import br.com.izifinance.izianalyse.dto.LoginInputDto;
import br.com.izifinance.izianalyse.security.TokenManager;

@RestController
@RequestMapping("/auth")
public class UserAuthenticationController {

	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenManager tokenManager;

	@PostMapping
	public ResponseEntity<?> authenticate(@RequestBody LoginInputDto loginInfo) {
		UsernamePasswordAuthenticationToken authenticationToken = loginInfo.build();
		try {
			Authentication authentication = manager.authenticate(authenticationToken);
			String jwt = tokenManager.generateToken(authentication);
			AuthenticationOutputDto tokenResponse = new AuthenticationOutputDto("Bearer", jwt);
			return ResponseEntity.ok(tokenResponse);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
