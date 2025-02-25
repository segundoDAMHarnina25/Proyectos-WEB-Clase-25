package com.adorno.controller;

import java.net.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.adorno.model.dtos.UserCreateDTO;
import com.adorno.services.UserService;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class PrincipalController {
	private final UserService userService;
	
	public PrincipalController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("hello")
	public String hello() {
		return "Hola que tal?";
	}

	@GetMapping("helloSecured")
	public String helloS() {
		System.out.println("PrincipalController: entrando en helloSecured");
		return "SEGURO Hola que tal?";
	}
	
	@GetMapping("helloSecuredAdmin")
	public String helloSAdmin() {
		System.out.println("PrincipalController: entrando en helloSecured");
		return "SEGURO Hola que tal?";
	}

	@PostMapping("new")
	public ResponseEntity<Boolean> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
		if (userService.createUser(userCreateDTO)) {
			return ResponseEntity.ok().body(true);
		}
		return ResponseEntity.badRequest().body(false);
	}

	@DeleteMapping("removal")
	public ResponseEntity<Boolean> delete(@RequestParam String username){
		return ResponseEntity.ok(userService.delete(username));
	}
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				userService.refreshingToken(response, authorizationHeader);
			} catch (StreamWriteException e) {
				e.printStackTrace();
			} catch (DatabindException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			  throw new RuntimeException("Refresh token is missing");
		}
	}
}
