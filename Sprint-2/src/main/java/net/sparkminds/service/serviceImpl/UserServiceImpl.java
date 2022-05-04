package net.sparkminds.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sparkminds.common.APIResponse;
import net.sparkminds.dto.LoginRequestDTO;
import net.sparkminds.dto.RegisterRequestDTO;
import net.sparkminds.entity.User;
import net.sparkminds.responsitory.UserRepository;
import net.sparkminds.service.UserService;
import net.sparkminds.util.JwtUtils;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtils jwtUtils; 

	@Override
	public APIResponse signup(RegisterRequestDTO registerRequestDTO) {
		// TODO Auto-generated method stub
		APIResponse apiResponse = new APIResponse();
		
		User userEntity = new User();

		userEntity.setLastname(registerRequestDTO.getLastname());
		userEntity.setEmailId(registerRequestDTO.getEmailId());
		userEntity.setFirstname(registerRequestDTO.getFirstname());
		userEntity.setPassword(registerRequestDTO.getPassword());
		userEntity.setAddress(registerRequestDTO.getAddress());
		userEntity.setPhoneNumber(registerRequestDTO.getPhoneNumber());

		userEntity = userRepository.save(userEntity);

		String token = jwtUtils.generateJwt(userEntity);
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("accessToken", token);
		
		apiResponse.setData(data);
		
		return apiResponse;
	}

	@Override
	public APIResponse login(LoginRequestDTO loginRequestDTO) {
		// TODO Auto-generated method stub
		APIResponse apiResponse = new APIResponse();
		
		User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(),
				loginRequestDTO.getPassword());
		
		if (user == null) {
			apiResponse.setData("Login failed");
			return apiResponse;
		}
		
		String token = jwtUtils.generateJwt(user);
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("accessToken", token);
		
		apiResponse.setData(data);
		
		return apiResponse;
	}

}
