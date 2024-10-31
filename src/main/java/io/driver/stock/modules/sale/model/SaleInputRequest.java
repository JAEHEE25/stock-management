package io.driver.stock.modules.sale.model;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.sale.domain.Sale;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleInputRequest {
	private String menu;
	private int saleQuantity;

	public Sale toSale(Menu menu) {
		return Sale.builder()
				.menu(menu)
				.saleQuantity(saleQuantity)
				.build();
	}
}
