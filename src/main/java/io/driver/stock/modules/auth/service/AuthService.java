package io.driver.stock.modules.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.driver.stock.modules.auth.model.LoginRequest;

@Service
public class AuthService {
	@Value("${blanche.username}")
	private String username;

	@Value("${blanche.password}")
	private String password;

	public boolean compareUsernameAndPassword(LoginRequest request) {
		String requestUsername = request.getUsername();
		String requestPassword = request.getPassword();
		return requestUsername.equals(username) && requestPassword.equals(password);
	}
}
