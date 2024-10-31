package io.driver.stock.modules.sale.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.menu.service.MenuService;
import io.driver.stock.modules.menuInfo.service.MenuInfoService;
import io.driver.stock.modules.sale.domain.Sale;
import io.driver.stock.modules.sale.domain.SaleRepository;
import io.driver.stock.modules.sale.model.SaleInputRequest;
import io.driver.stock.modules.stock.domain.Stock;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleService {
	private final MenuService menuService;
	private final MenuInfoService menuInfoService;
	private final SaleRepository saleRepository;

	@Transactional
	public void saveSale(SaleInputRequest request) {
		Menu menu = menuService.findMenuByName(request.getMenu());
		Sale sale = request.toSale(menu);
		saleRepository.save(sale);
		updateCurrentQuantity(sale);
	}

	private void updateCurrentQuantity(Sale sale) {
		Menu menu = sale.getMenu();
		int saleQuantity = sale.getSaleQuantity();
		menuInfoService.getMenuInfosByMenu(menu).forEach(menuInfo -> {
			// 1개에 필요한 재고와 수량
			Stock stock = menuInfo.getStock();
			int quantity = menuInfo.getQuantity();
			stock.changeCurrentQuantity(stock.getCurrentQuantity() - quantity * saleQuantity);
		});
	}
}
