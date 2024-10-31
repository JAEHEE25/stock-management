package io.driver.stock.modules.sale.domain;

import io.driver.stock.modules.menu.domain.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

	@Column(nullable = false)
	private int saleQuantity;
}
