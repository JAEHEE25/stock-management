package io.driver.stock.modules.menuInfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.menuInfo.domain.MenuInfo;
import io.driver.stock.modules.menuInfo.domain.MenuInfoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuInfoService {
	private final MenuInfoRepository menuInfoRepository;

	public List<MenuInfo> getMenuInfosByMenu(Menu menu) {
		return menuInfoRepository.findAllByMenu(menu);
	}
}
