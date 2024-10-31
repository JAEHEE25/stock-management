package io.driver.stock.modules.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.menu.domain.MenuRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
	private final MenuRepository menuRepository;

	public List<Menu> getMenus() {
		return menuRepository.findAll();
	}

	public Menu findMenuByName(String name) {
		return menuRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));
	}
}
