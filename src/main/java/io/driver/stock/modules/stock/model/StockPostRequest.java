package io.driver.stock.modules.stock.model;

import java.time.LocalDate;

import io.driver.stock.modules.stock.domain.Stock;
import io.driver.stock.modules.stock.domain.StockCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockPostRequest {
	private String name;
	private StockCategory stockCategory;
	private int purchaseQuantity;
	private int cost;
	private String purchasePlace;
	private LocalDate purchaseDate;

	public Stock toStock() {
		return Stock.builder()
				.name(name)
				.stockCategory(stockCategory)
				.purchaseQuantity(purchaseQuantity)
				.cost(cost)
				.purchasePlace(purchasePlace)
				.purchaseDate(purchaseDate)
				.currentQuantity(purchaseQuantity)
				.deleted(false)
				.build();
	}

}
