package io.driver.stock.modules.auth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	private String username;
	private String password;
}
