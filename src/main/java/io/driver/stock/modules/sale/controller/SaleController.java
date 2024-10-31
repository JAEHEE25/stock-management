package io.driver.stock.modules.sale.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.menu.service.MenuService;
import io.driver.stock.modules.sale.model.SaleInputRequest;
import io.driver.stock.modules.sale.service.SaleService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {
	private final MenuService menuService;
	private final SaleService saleService;

	@GetMapping
	public String getSalePage(Model model) {
		List<Menu> menus = menuService.getMenus();
		model.addAttribute("menus", menus);
		return "sale/input";
	}

	@PostMapping
	public String saveSale(@ModelAttribute SaleInputRequest request) {
		saleService.saveSale(request);
		return "redirect:/sale";
	}

}
