package io.driver.stock.modules.menuInfo.domain;

import io.driver.stock.modules.menu.domain.Menu;
import io.driver.stock.modules.stock.domain.Stock;
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
public class MenuInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuInfoId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private int quantity;
}
