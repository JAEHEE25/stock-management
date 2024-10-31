package io.driver.stock.modules.stock.domain;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("deleted = false")
@SQLDelete(sql = "UPDATE stock SET deleted = true WHERE stock_id = ?")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StockCategory stockCategory;

	@Column(nullable = false)
	private int purchaseQuantity;

	@Column(nullable = false)
	private int cost;

	@Column(nullable = false)
	private String purchasePlace;

	@Column(nullable = false)
	private LocalDate purchaseDate;

	@Column(nullable = false)
	private int currentQuantity;

	@Column(nullable = false)
	private boolean deleted;

	public void modifyStock(Stock newStock) {
		this.name = newStock.getName();
		this.stockCategory = newStock.getStockCategory();
		this.purchaseQuantity = newStock.getPurchaseQuantity();
		this.cost = newStock.getCost();
		this.purchasePlace = newStock.getPurchasePlace();
		this.purchaseDate = newStock.getPurchaseDate();
		this.currentQuantity = newStock.getCurrentQuantity();
	}

	public void changeCurrentQuantity(int newQuantity) {
		this.currentQuantity = newQuantity;
	}
}
