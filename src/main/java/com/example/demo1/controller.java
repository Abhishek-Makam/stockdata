package com.example.demo1;

import com.example.demo1.stock;
import com.example.demo1.service.stockservice;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class controller {

    private static final Logger logger = LoggerFactory.getLogger(controller.class);

    private final stockservice stockService;

    @GetMapping("/getStockData")
    public List<stock> getStockData() {
        try {
            List<stock> stockData = stockService.getCompanyData();
            logger.info("Retrieved stock data: {}", stockData);
            return stockData;
        } catch (Exception e) {
            logger.error("Error while retrieving stock data", e);
            // Handle the exception or rethrow it based on your requirements
            throw new RuntimeException("Error while retrieving stock data", e);
        }
    }
}
