package io.driver.stock.modules.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.driver.stock.modules.stock.domain.Stock;
import io.driver.stock.modules.stock.domain.StockRepository;
import io.driver.stock.modules.stock.model.StockModifyRequest;
import io.driver.stock.modules.stock.model.StockPostRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {
	private final StockRepository stockRepository;

	public List<Stock> getStocks() {
		return stockRepository.findAll();
	}

	public Stock getStockById(Long stockId) {
		return stockRepository.findById(stockId).orElseThrow(() -> new IllegalArgumentException("데이터가 존재하지 않습니다."));
	}

	@Transactional
	public void saveStock(StockPostRequest request) {
		Stock stock = request.toStock();
		stockRepository.save(stock);
	}

	@Transactional
	public void modifyStock(Long stockId, StockModifyRequest request) {
		Stock stock = getStockById(stockId);
		stock.modifyStock(request.toStock());
	}

	@Transactional
	public void deleteStock(Long stockId) {
		Stock stock = getStockById(stockId);
		stockRepository.delete(stock);
	}
}
