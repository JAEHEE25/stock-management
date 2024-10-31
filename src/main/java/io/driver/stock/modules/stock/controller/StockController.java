package io.driver.stock.modules.stock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.driver.stock.modules.stock.domain.Stock;
import io.driver.stock.modules.stock.domain.StockCategory;
import io.driver.stock.modules.stock.model.StockModifyRequest;
import io.driver.stock.modules.stock.model.StockPostRequest;
import io.driver.stock.modules.stock.service.StockService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;

	@GetMapping
	public String getStockList(Model model, @RequestParam(required = false, name = "category") StockCategory category) {
		List<Stock> stocks = stockService.getStocksByCategory(category);
		model.addAttribute("categories", StockCategory.values());
		model.addAttribute("selectedCategory", category);
		model.addAttribute("stocks", stocks);
		return "stock/list";
	}

	@GetMapping("/post")
	public String addStockPage(Model model) {
		model.addAttribute("categories", StockCategory.values());
		return "stock/post";
	}

	@PostMapping
	public String addStock(@ModelAttribute StockPostRequest request) {
		stockService.saveStock(request);
		return "stock/post";
	}

	@GetMapping("/{stockId}")
	public String modifyStock(@PathVariable(name = "stockId") Long stockId, Model model) {
		Stock stock = stockService.getStockById(stockId);
		model.addAttribute("stock", stock);
		model.addAttribute("categories", StockCategory.values());
		return "stock/modify";
	}

	@PatchMapping("/{stockId}")
	public String modifyStock(@PathVariable(name = "stockId") Long stockId, @ModelAttribute StockModifyRequest request) {
		stockService.modifyStock(stockId, request);
		return "redirect:/stock";
	}

	@DeleteMapping("/{stockId}")
	public String removeStock(@PathVariable(name = "stockId") Long stockId) {
		stockService.deleteStock(stockId);
		return "redirect:/stock";
	}
}
