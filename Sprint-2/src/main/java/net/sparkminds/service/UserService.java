package net.sparkminds.service;

import net.sparkminds.common.APIResponse;
import net.sparkminds.dto.LoginRequestDTO;
import net.sparkminds.dto.RegisterRequestDTO;

public interface UserService {
	APIResponse signup(RegisterRequestDTO registerRequestDTO);
	APIResponse login(LoginRequestDTO loginRequestDTO);
}
