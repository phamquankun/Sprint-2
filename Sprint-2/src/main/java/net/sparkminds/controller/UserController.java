package net.sparkminds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.common.APIResponse;
import net.sparkminds.dto.LoginRequestDTO;
import net.sparkminds.dto.RegisterRequestDTO;
import net.sparkminds.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUp(@RequestBody RegisterRequestDTO registerRequestDTO) {
		APIResponse apiResponse = userService.signup(registerRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	@PostMapping("/login")
	public ResponseEntity<APIResponse> logIn(@RequestBody LoginRequestDTO loginRequestDTO) {
		APIResponse apiResponse = userService.login(loginRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
}
