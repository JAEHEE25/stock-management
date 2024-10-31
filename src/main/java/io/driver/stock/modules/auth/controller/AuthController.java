package io.driver.stock.modules.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.driver.stock.modules.auth.model.LoginRequest;
import io.driver.stock.modules.auth.service.AuthService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "auth/login";
	}

	@PostMapping("/login")
	public String loginPage(@ModelAttribute LoginRequest request, Model model) {
		boolean isCorrect = authService.compareUsernameAndPassword(request);
		if (!isCorrect) {
			model.addAttribute("errorMessage", "아이디나 비밀번호가 일치하지 않습니다.");
            return "auth/login";
		}
		return "redirect:/stock";
	}
}
